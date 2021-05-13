package cosmetic.controller.web;

import com.mysql.fabric.Response;
import cosmetic.entity.*;
import cosmetic.repository.*;
import cosmetic.until.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.net.http.HttpResponse;
import java.util.List;

@Controller
@RequestMapping("payment")
public class PaymentController {

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

    @RequestMapping
    public String payment(Model model, @RequestParam("priceTotal") String priceTotal) {
        CustomerEntity customerEntity = customerRepository.findOneByEmail(SecurityUtil.getPrincipal().getUsername());
        model.addAttribute("priceTotal", priceTotal);
        model.addAttribute("order", new OrdersEntity());
        return "/web/payment";
    }

    @PostMapping("detailOrder")
    public String order(ProductEntity productEntity,
                        DetailOrderEntity detailOrderEntity,CustomerEntity customerEntity, Model model,
                        @Valid @ModelAttribute("order") OrdersEntity ordersEntity)
                        throws UnsupportedEncodingException {
        customerEntity = SecurityUtil.getPrincipal().getCustomer();
        ordersEntity.setCustomerEntity(customerEntity);
        orderRepository.save(ordersEntity);
        List<CartEntity> cartEntity = cartRepository.findALlByCustomerEntity_IdCustomer(SecurityUtil.getPrincipal().getCustomer().getIdCustomer());

        for (CartEntity entity : cartEntity) {
            detailOrderEntity.setId(null);
            detailOrderEntity.setAmount(entity.getNumber());
            detailOrderEntity.setNameProduct(entity.getProductEntity().getNameProduct());
            detailOrderEntity.setPrice(entity.getNumber() * entity.getProductEntity().getPrice());
            detailOrderEntity.setOrder(ordersEntity);

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
