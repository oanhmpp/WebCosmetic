package cosmetic.controller.web;


import cosmetic.service.ProductDetailService;
import cosmetic.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class CartController {

    @Autowired
    ProductDetailService productDetailService;
    @Autowired
    ProductService productService;

    @RequestMapping("/cart")
    public String cart(Model model, @RequestParam Long id){
        model.addAttribute("product",productService.findOneById(id));
        model.addAttribute("productDetail",productDetailService.findOneById(id));

        return "web/cart";
    }
}
