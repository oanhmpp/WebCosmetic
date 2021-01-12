package cosmetic.controller.web;

import cosmetic.entity.CustomerEntity;
import cosmetic.entity.OrdersEntity;
import cosmetic.service.CustomerService;
import cosmetic.service.OrderService;
import cosmetic.until.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("payment")
public class PaymentController {

    @Autowired
    CustomerService customerService;
    @Autowired
    OrderService orderService;

    @RequestMapping
    public String payment(Model model,@RequestParam("priceTotal") String priceTotal){
        CustomerEntity customerEntity = customerService.findOneByEmail(SecurityUtil.getPrincipal().getUsername());
        model.addAttribute("priceTotal",priceTotal);
        model.addAttribute("order",new OrdersEntity());
        return "/web/payment";
    }

    @PostMapping("order")
    public String order(@Valid @ModelAttribute("order") OrdersEntity ordersEntity){
        orderService.save(ordersEntity);
        return "web/detailOrder";
    }
}
