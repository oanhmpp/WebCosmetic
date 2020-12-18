package cosmetic.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WishListController {

    @RequestMapping("/wishlist")
    public String wishlist(){
        return "web/wishlist";
    }
}
