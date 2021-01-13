package cosmetic.controller.web;

import com.mysql.fabric.Response;
import cosmetic.entity.*;
import cosmetic.service.*;
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
    CustomerService customerService;
    @Autowired
    OrderService orderService;
    @Autowired
    CartService cartService;
    @Autowired
    ProductService productService;
    @Autowired
    DetailOrderService detailOrderService;

    @RequestMapping
    public String payment(Model model, @RequestParam("priceTotal") String priceTotal) {
        CustomerEntity customerEntity = customerService.findOneByEmail(SecurityUtil.getPrincipal().getUsername());
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
        orderService.save(ordersEntity);
        List<CartEntity> cartEntity = cartService.findByCustomerEntity_Id(SecurityUtil.getPrincipal().getCustomer().getIdCustomer());

        for (CartEntity entity : cartEntity) {
            detailOrderEntity.setId(null);
            detailOrderEntity.setAmount(entity.getNumber());
            detailOrderEntity.setNameProduct(entity.getProductEntity().getNameProduct());
            detailOrderEntity.setPrice(entity.getNumber() * entity.getProductEntity().getPrice());
            detailOrderEntity.setOrder(ordersEntity);

            detailOrderService.save(detailOrderEntity);

            // giam so luong sp trong product
            productEntity = productService.findOneById(entity.getProductEntity().getIdProduct());
            productEntity.setAmount(productEntity.getAmount() - detailOrderEntity.getAmount());
            productService.save(productEntity);

            cartService.deleteCart(entity.getId());
        }
        List<DetailOrderEntity> listDetailOrder = detailOrderService.findByIDOrder(ordersEntity.getIdOrder());
        model.addAttribute("order", ordersEntity);
        model.addAttribute("detailOrderList", listDetailOrder);
        return "web/detailOrder";
    }
}
