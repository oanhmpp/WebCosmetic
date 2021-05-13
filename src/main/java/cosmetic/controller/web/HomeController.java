package cosmetic.controller.web;

import cosmetic.entity.ProductEntity;
import cosmetic.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String showHome(Model model) {
        model.addAttribute("listProduct", productService.findRandomPro());
        return "web/index";
    }

    @GetMapping("/login")
    public String home() {
        return "web/login";
    }

    @GetMapping("/search")
    @ResponseBody
    public List<ProductEntity> find(@RequestParam("key") String key) {
        return productService.search(key);
    }
}
