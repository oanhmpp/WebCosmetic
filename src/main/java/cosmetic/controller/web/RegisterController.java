package cosmetic.controller.web;

import cosmetic.entity.CustomerEntity;
import cosmetic.entity.RoleEntity;
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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

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
    public String registerCheckForm(RoleEntity roleEntity,Model model,
                                    CustomerValidate customerValidate,
                                    @Valid @ModelAttribute("customer") CustomerEntity customerEntity,
                                    BindingResult result) {
        customerValidate.validateExist(customerEntity, result, customerService.findByEmail(customerEntity.getEmail()).isEmpty());
        customerValidate.validate(customerEntity,result);
        if (result.hasErrors()) {
            System.out.println("loi");
                return "web/register";
        }
        else {
            roleEntity.setIdRole(2L);
            List<RoleEntity> list = new ArrayList<>();
            list.add(roleEntity);
            customerEntity.setPassword(passwordEncoder.encode(customerEntity.getPassword()));
            customerEntity.setRoleEntityList(list);
            customerService.save(customerEntity);
            model.addAttribute("customer", customerEntity);
            return "redirect:/";
        }
    }

    @RequestMapping("checkEmail")
    public @ResponseBody
    boolean checkEmail(CustomerValidate customerValidate,
                       @Valid @ModelAttribute("customer") CustomerEntity customerEntity,
                       BindingResult result,
                       @RequestParam("email") String email){
        System.out.println(email);
        List<CustomerEntity> check = customerService.findByEmail(email);
        if(check.isEmpty()){
            return true;
        }
        else {
            return false;
        }
    }
}
