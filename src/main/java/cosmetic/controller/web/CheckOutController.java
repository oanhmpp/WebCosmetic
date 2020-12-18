package cosmetic.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CheckOutController {

    @RequestMapping("/checkout")
    public String checkout(){
        return "web/checkout";
    }
}
