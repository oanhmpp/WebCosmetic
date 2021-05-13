package cosmetic.controller.web;

import cosmetic.entity.ConfirmationToken;
import cosmetic.entity.CustomerEntity;
import cosmetic.entity.RoleEntity;
import cosmetic.repository.ConfirmationTokenRepository;
import cosmetic.repository.CustomerRespository;
import cosmetic.service.EmailSenderService;
import cosmetic.validator.CustomerValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RegisterController {

    @Autowired
    private CustomerRespository customerRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    EmailSenderService emailSenderService;

    @Autowired
    ConfirmationTokenRepository confirmationTokenRepository;

    @RequestMapping("/register")
    public String register(Model model) {
        model.addAttribute("customer", new CustomerEntity());
        return "/web/register";
    }

    @PostMapping("/register")
    public String registerCheckForm(RoleEntity roleEntity, RedirectAttributes redirectAttributes,
                                    CustomerValidate customerValidate,
                                    @Valid @ModelAttribute("customer") CustomerEntity customerEntity,
                                    BindingResult result) {
        customerValidate.validateExist(customerEntity, result, customerRepository.findByEmail(customerEntity.getEmail()).isEmpty());
        customerValidate.validate(customerEntity, result);
        if (result.hasErrors()) {
            return "web/register";
        } else {
            roleEntity.setIdRole(2L);
            List<RoleEntity> list = new ArrayList<>();
            list.add(roleEntity);
            customerEntity.setPassword(passwordEncoder.encode(customerEntity.getPassword()));
            customerEntity.setRoleEntityList(list);
            ConfirmationToken confirmationToken = new ConfirmationToken(customerEntity);
            emailSenderService.sendEmail(customerEntity.getEmail(), "Registration confirmation", "To confirm your account, please click here : "
                    + "http://localhost:8080/confirm-account?token=" + confirmationToken.getConfirmationToken());
            customerRepository.save(customerEntity);
            confirmationTokenRepository.save(confirmationToken);
            redirectAttributes.addFlashAttribute("msg", "Please check your email");
            return "redirect:/login";
        }
    }

    @RequestMapping(value="/confirm-account", method= {RequestMethod.GET, RequestMethod.POST})
    public String confirmUserAccount(RedirectAttributes redirectAttributes , @RequestParam("token")String confirmationToken)
    {
        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);

        if(token != null)
        {
            CustomerEntity user = customerRepository.findOneByEmail(token.getUser().getEmail());
            user.setEnabled(true);
            customerRepository.save(user);
            // tranh truong hop resubmit form
            redirectAttributes.addFlashAttribute("msg","Account verified !!!!");
        }
        else
        {
            redirectAttributes.addFlashAttribute("msg","The link is invalid or broken!");
        }

        return "redirect:/login";
    }

    @RequestMapping("/checkEmail")
    public @ResponseBody
    boolean checkEmail(CustomerValidate customerValidate,
                       @Valid @ModelAttribute("customer") CustomerEntity customerEntity,
                       BindingResult result,
                       @RequestParam("email") String email) {
        List<CustomerEntity> check = customerRepository.findByEmail(email);
        if (check.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }


}
