package cosmetic.controller.web;

import cosmetic.entity.CustomerEntity;
import cosmetic.repository.CustomerRespository;
import cosmetic.repository.MessageRepository;
import cosmetic.service.CustomerService;
import cosmetic.validator.CustomerValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @RequestMapping("/register")
    public String register(Model model) {
        model.addAttribute("customer", new CustomerEntity());
        return "/web/register";
    }

    @PostMapping("/register")
    public String registerCheckForm(Model model, CustomerValidate customerValidate, @Valid @ModelAttribute("customer") CustomerEntity customerEntity, BindingResult result) {
        customerValidate.validateExist(customerEntity, result, customerService.findByEmail(customerEntity.getEmail()).isEmpty());
        customerValidate.validate(customerEntity,result);
        if (result.hasErrors()) {
            System.out.println("loi");
                return "web/register";
        }
        else {
            customerEntity.setPassword(passwordEncoder.encode(customerEntity.getPassword()));
            customerService.save(customerEntity);
            model.addAttribute("customer", customerEntity);
            return "redirect:/";
        }
    }
}
