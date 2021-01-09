package cosmetic.controller.auth;

import cosmetic.Validate.Validate;
import cosmetic.entity.CustomerEntity;
import cosmetic.service.CustomerService;
import cosmetic.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller("WebAuthentication")
public class AuthController {
//    @Autowired
//    private PasswordEncoder pass;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/login")
    private String login(){
        return "authentication/login";
    }
    @GetMapping("/register")
    public String register(@ModelAttribute("user")CustomerService userEntity){
        return "authentication/register";
    }

    public String submit(Model model, @ModelAttribute("user") CustomerEntity userEntity, BindingResult result, Validate validate){
        validate.validate(userEntity,result);
        if(result.hasErrors()){
            return "authentication/login";
        }
//        userEntity.setPassword(pass.encode(userEntity.getPassword()));
        customerService.save(userEntity);
        model.addAttribute("msg","Successful");
        return "authentication/login";
    }
    @PostMapping("/register/validate")
    @ResponseBody
    public JsonResult<String> validateEmail(@RequestBody CustomerEntity customerEntity){
        System.out.println(customerEntity.getEmail());
//        if (customerService.checkEmail(userEntity.getEmail())){
//            return  new JsonResult <String>().ok("Email da ton tai",null);
//        }
        return  new JsonResult <String>().ok("Email khong hop le",null);
    }
//    @GetMapping("/Logout")
//    public String logout(HttpServletRequest request, HttpServletResponse response){
//        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
//        if(auth!=null){
//            new SecurityContextLogoutHandler().
//        }
//        return "redirect:/";
//    }
}
