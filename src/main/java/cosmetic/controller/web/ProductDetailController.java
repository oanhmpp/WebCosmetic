package cosmetic.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductDetailController {

    @RequestMapping("/productDetail")
    public String productDetail(){
        return "web/product-detail";
    }
}
