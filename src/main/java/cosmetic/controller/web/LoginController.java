package cosmetic.controller.web;

import cosmetic.entity.ConfirmationToken;
import cosmetic.entity.CustomerEntity;
import cosmetic.repository.ConfirmationTokenRepository;
import cosmetic.repository.CustomerRespository;
import cosmetic.service.CustomerService;
import cosmetic.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class LoginController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    EmailSenderService emailSenderService;
    @Autowired
    ConfirmationTokenRepository confirmationTokenRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    String emailPublic;
    @RequestMapping("/login")
    public String login(){
        return "web/index";
    }

    @RequestMapping("/logout")
    public String logout(){
        return "redirect:/";
    }

    @RequestMapping("/forgotPass")
    public String forgotPass(){
        return "/web/forgotPass";
    }

    @RequestMapping("/forgotPassword")
    public String forgotPassword (@RequestParam String email,  RedirectAttributes redirectAttributes){
        CustomerEntity existingUser = customerService.findOneByEmail(email);
        emailPublic = email;
        if (existingUser != null) {
            // Create token
            ConfirmationToken confirmationToken = new ConfirmationToken(existingUser);

            // Save it
            confirmationTokenRepository.save(confirmationToken);
            emailSenderService.sendEmail(email, "To complete the password reset process, please click here: ", "To confirm your account, please click here : "
                    + "http://localhost:8080/confirm-reset?token=" + confirmationToken.getConfirmationToken());
            redirectAttributes.addFlashAttribute("msg", "Please check your email");

        } else {
            redirectAttributes.addFlashAttribute("msg", "This email address does not exist!");
        }
        return "redirect:/login";
    }
    @RequestMapping(value="/confirm-reset", method= {RequestMethod.GET, RequestMethod.POST})
    public String validateResetToken(  RedirectAttributes redirectAttributes, @RequestParam("token")String confirmationToken) {
        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);

        if (token != null) {
            CustomerEntity user = customerService.findOneByEmail(token.getUser().getEmail());
            user.setEnabled(true);
            customerService.save(user);
            return "/web/resetPassword";
        } else {
            redirectAttributes.addFlashAttribute("msg", "The link is invalid or broken!!");

        }
        return "redirect:/login";
    }

    @RequestMapping("reset-password")
    public String resetPassword (RedirectAttributes redirectAttributes,Model model,@RequestParam String pass,@RequestParam String rePass){
        if(pass.length()>7 && rePass.length()>7){
            if(pass.equals(rePass)){
                CustomerEntity customerEntity = customerService.findOneByEmail(emailPublic);
                customerEntity.setPassword(passwordEncoder.encode(pass));
                customerService.save(customerEntity);
//                CustomerEntity tokenUser = customerService.findOneByEmail(customerEntity.getEmail());
//                System.out.println(tokenUser.getPhone()+"-"+tokenUser.getEmail());
//                tokenUser.setPassword(passwordEncoder.encode(pass));
//                customerService.save(tokenUser);
                redirectAttributes.addFlashAttribute("msg", "Reset password is success! Please login again..");

            }else{
                redirectAttributes.addFlashAttribute("msg", "Re-entered password is incorrect.. Reset password is error!");
            }
        }else {
            redirectAttributes.addFlashAttribute("msg", "Password must be more than 8 characters... Reset password is error!");
        }
        return "redirect:/login";
    }
}
