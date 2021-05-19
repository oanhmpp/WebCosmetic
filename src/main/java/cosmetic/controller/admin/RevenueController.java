package cosmetic.controller.admin;

import cosmetic.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin/revenue")
// doanh thu
public class RevenueController {

    @Autowired
    private OrderRepository orderRepository;

    @RequestMapping("/year")
    public String revenueMonth(Model model) {
        model.addAttribute("listYear", orderRepository.findYear());
        return "admin/revenue_year";
    }

    @PostMapping("/revenueByYear")
    @ResponseBody
    public List<?> revenueByYear(@RequestParam String year) {
        return orderRepository.revenueByYear(year);
    }

}
