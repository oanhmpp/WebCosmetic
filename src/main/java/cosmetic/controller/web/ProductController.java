package cosmetic.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

    @RequestMapping("/product")
    public String product(){
        return "web/product-list";
    }
}