package cosmetic.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginRegisterController {

    @RequestMapping("/loginRegister")
    public String loginRegister(){
        return "web/login_register";
    }
}
