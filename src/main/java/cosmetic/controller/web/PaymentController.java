package cosmetic.controller.web;

import antlr.Utils;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import cosmetic.entity.*;
import cosmetic.repository.*;
import cosmetic.service.PaypalService;
import cosmetic.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("payment")
public class PaymentController {

    public static final String URL_PAYPAL_SUCCESS = "pay/success";
    public static final String URL_PAYPAL_CANCEL = "pay/cancel";

    @Autowired
    private PaypalService paypalService;

    @Autowired
    CustomerRespository customerRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    DetailOrderRepository detailOrderRepository;

    @RequestMapping("/paymentOnDelivery")
    public String payment(Model model, @RequestParam("priceTotal") String priceTotal) {
        CustomerEntity customerEntity = customerRepository.findOneByEmail(SecurityUtil.getPrincipal().getUsername());
        model.addAttribute("priceTotal", priceTotal);
        model.addAttribute("order", new OrdersEntity());
        return "/web/payment";
    }

    @RequestMapping("paymentOnline")
    public String paymentOnline(Model model, @RequestParam("priceTotal") String priceTotal) {
        CustomerEntity customerEntity = customerRepository.findOneByEmail(SecurityUtil.getPrincipal().getUsername());
        model.addAttribute("priceTotal", priceTotal);
        model.addAttribute("order", new OrdersEntity());
        return "/web/payment_online";
    }

    @GetMapping("/paymentOnl")
    public String paymentOnl(ProductEntity productEntity,
                             DetailOrderEntity detailOrderEntity,
                             CustomerEntity customerEntity,
                             Model model,
                             @Valid @ModelAttribute("order") OrdersEntity ordersEntity,
                             HttpServletRequest request) {
        customerEntity = SecurityUtil.getPrincipal().getCustomer();
        ordersEntity.setCustomerEntity(customerEntity);
        ordersEntity.setDate(new Date());
        ordersEntity.setState("Paid -1");
        orderRepository.save(ordersEntity);

        String cancelUrl = ServletUriComponentsBuilder.fromRequestUri(request).replacePath(null).build().toUriString() + "/payment/" + URL_PAYPAL_CANCEL+"?idOrder="+ordersEntity.getIdOrder();
        String successUrl = ServletUriComponentsBuilder.fromRequestUri(request).replacePath(null).build().toUriString() + "/payment/" + URL_PAYPAL_SUCCESS+"?idOrder="+ordersEntity.getIdOrder();
        try {
            Payment payment = paypalService.createPayment(
                    ordersEntity.getTotalPrice(),
                    "USD",
                    "paypal",
                    "sale",
                    "payment description",
                    cancelUrl,
                    successUrl);
            for (Links links : payment.getLinks()) {
                if (links.getRel().equals("approval_url")) {
                    return "redirect:" + links.getHref();
                }
            }
        } catch (PayPalRESTException e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

    @GetMapping(URL_PAYPAL_CANCEL)
    public String cancelPay(Model model,@RequestParam("idOrder") Long id) {
        model.addAttribute("msg", "Payment failed");
        OrdersEntity ordersEntity = orderRepository.findOneByIdOrder(id);
        orderRepository.delete(ordersEntity);
        CustomerEntity customerEntity = customerRepository.findOneByEmail(SecurityUtil.getPrincipal().getUsername());
        List<CartEntity> cartEntities = cartRepository.findALlByCustomerEntity_IdCustomer(customerEntity.getIdCustomer());
        model.addAttribute("cart", cartEntities);
        return "web/cart";
    }

    @GetMapping(URL_PAYPAL_SUCCESS)
    public String successPay( Model model,
                             DetailOrderEntity detailOrderEntity,
                             ProductEntity productEntity,
                             @RequestParam("paymentId") String paymentId,
                             @RequestParam("PayerID") String payerId,
                             @RequestParam("idOrder") Long id) {
        try {
            Payment payment = paypalService.executePayment(paymentId, payerId);
            if (payment.getState().equals("approved")) {
                OrdersEntity ordersEntity = orderRepository.findOneByIdOrder(id);
                ordersEntity.setState("Paid");
                orderRepository.save(ordersEntity);

                List<CartEntity> cartEntity = cartRepository.findALlByCustomerEntity_IdCustomer(SecurityUtil.getPrincipal().getCustomer().getIdCustomer());

                for (CartEntity entity : cartEntity) {
                    detailOrderEntity.setId(null);
                    detailOrderEntity.setAmount(entity.getNumber());
                    detailOrderEntity.setNameProduct(entity.getProductEntity().getNameProduct());
                    detailOrderEntity.setPrice(entity.getNumber() * entity.getProductEntity().getPrice());
                    detailOrderEntity.setOrder(ordersEntity);
                    detailOrderEntity.setIdProduct(entity.getProductEntity().getIdProduct());
                    detailOrderRepository.save(detailOrderEntity);

                    // giam so luong sp trong product
                    productEntity = productRepository.findById(entity.getProductEntity().getIdProduct()).get();
                    productEntity.setAmount(productEntity.getAmount() - detailOrderEntity.getAmount());
                    productRepository.save(productEntity);

                    cartRepository.deleteById(entity.getId());
                }

                List<DetailOrderEntity> listDetailOrder = detailOrderRepository.findByOrder_IdOrder(ordersEntity.getIdOrder());
                model.addAttribute("order", ordersEntity);
                model.addAttribute("detailOrderList", listDetailOrder);

                return "web/detailOrder";
            }
        } catch (PayPalRESTException e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

    @PostMapping("detailOrder")
    public String order(ProductEntity productEntity,
                        DetailOrderEntity detailOrderEntity, CustomerEntity customerEntity, Model model,
                        @Valid @ModelAttribute("order") OrdersEntity ordersEntity)
            throws UnsupportedEncodingException {
        customerEntity = SecurityUtil.getPrincipal().getCustomer();
        ordersEntity.setCustomerEntity(customerEntity);
        ordersEntity.setDate(new Date());
        ordersEntity.setState("Unpaid");
        orderRepository.save(ordersEntity);
        List<CartEntity> cartEntity = cartRepository.findALlByCustomerEntity_IdCustomer(SecurityUtil.getPrincipal().getCustomer().getIdCustomer());

        for (CartEntity entity : cartEntity) {
            detailOrderEntity.setId(null);
            detailOrderEntity.setAmount(entity.getNumber());
            detailOrderEntity.setNameProduct(entity.getProductEntity().getNameProduct());
            detailOrderEntity.setPrice(entity.getNumber() * entity.getProductEntity().getPrice());
            detailOrderEntity.setOrder(ordersEntity);
            detailOrderEntity.setIdProduct(entity.getProductEntity().getIdProduct());
            detailOrderRepository.save(detailOrderEntity);

            // giam so luong sp trong product
            productEntity = productRepository.findById(entity.getProductEntity().getIdProduct()).get();
            productEntity.setAmount(productEntity.getAmount() - detailOrderEntity.getAmount());
            productRepository.save(productEntity);

            cartRepository.deleteById(entity.getId());
        }
        List<DetailOrderEntity> listDetailOrder = detailOrderRepository.findByOrder_IdOrder(ordersEntity.getIdOrder());
        model.addAttribute("order", ordersEntity);
        model.addAttribute("detailOrderList", listDetailOrder);
        return "web/detailOrder";
    }
}
