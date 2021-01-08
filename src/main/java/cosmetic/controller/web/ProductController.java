package cosmetic.controller.web;

import cosmetic.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("WebProduct")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/product")
    public String product(Model model) {
        model.addAttribute("listProduct", productService.findAll());
        return "web/product-list";
    }
}
