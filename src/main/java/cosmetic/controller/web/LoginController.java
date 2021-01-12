package cosmetic.controller.web;

import cosmetic.entity.CustomerEntity;
import cosmetic.repository.CustomerRespository;
import cosmetic.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class LoginController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping("/login")
    public String login(){
        return "web/index";
    }

    @RequestMapping("/logout")
    public String logout(){
        return "redirect:/";
    }
}
