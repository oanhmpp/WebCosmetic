package cosmetic.controller.admin;

import cosmetic.service.DetailOrderService;
import cosmetic.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    DetailOrderService detailOrderService;
    @RequestMapping("list")
    public String listOrder(Model model){
        model.addAttribute("orderList",orderService.findAll());
        model.addAttribute("detailOrderList",detailOrderService.findAll());
        return "admin/listOrder";
    }
}
