package cosmetic.controller.admin;

import cosmetic.repository.DetailOrderRepository;
import cosmetic.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/order")
public class OrderController {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    DetailOrderRepository detailOrderRepository;
    @RequestMapping("list")
    public String listOrder(Model model){
        model.addAttribute("orderList",orderRepository.findAll());
        model.addAttribute("detailOrderList",detailOrderRepository.findAll());
        return "admin/listOrder";
    }
}
