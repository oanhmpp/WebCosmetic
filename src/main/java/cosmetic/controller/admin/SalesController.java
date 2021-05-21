package cosmetic.controller.admin;

import cosmetic.repository.BrandRepository;
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
@RequestMapping("/admin/sales")
public class SalesController {
    @Autowired
    OrderRepository orderRepository;

    @RequestMapping("/brand")
    public String salesByBrand(Model model) {
        return "admin/sales_brand";
    }

    @PostMapping("salesByBrand")
    @ResponseBody
    public List<?> salesByBrand(@RequestParam String year1, @RequestParam String year2) {
        List<?> list = orderRepository.salesByBrand(year1, year2);
        return list;
    }

    @RequestMapping("/year")
    public String salesByYear(Model model){
        model.addAttribute("listYear", orderRepository.findYear());
        return "admin/sales_year";
    }

    @PostMapping("salesByYear")
    @ResponseBody
    public List<?> salesByYear(@RequestParam String year) {
        List<?> list = orderRepository.salesByYear(year);
        return list;
    }

}
