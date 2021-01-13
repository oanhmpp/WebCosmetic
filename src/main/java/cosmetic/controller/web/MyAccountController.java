package cosmetic.controller.web;

import cosmetic.entity.CustomerEntity;
import cosmetic.entity.RoleEntity;
import cosmetic.service.CustomerService;
import cosmetic.service.DetailOrderService;
import cosmetic.service.OrderService;
import cosmetic.until.SecurityUtil;
import cosmetic.validator.CustomerValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MyAccountController {

    @Autowired
    CustomerService customerService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    OrderService orderService;
    @Autowired
    DetailOrderService detailOrderService;

    @RequestMapping("/myAccount")
    public String myAccount(Model model){
        CustomerEntity customerEntity = customerService.findOneByEmail(SecurityUtil.getPrincipal().getUsername());
        model.addAttribute("myAccount",customerEntity);
        return "web/my-account";
    }

//    @PostMapping("myAccount/edit")
//    public String edited(RoleEntity roleEntity,Model model,
//                         @Valid @ModelAttribute("myAccount") CustomerEntity customerEntity,
//                         CustomerValidate customerValidate,
//                         BindingResult result) {
//        customerValidate.validateAdmin(customerEntity,result);
//        if (result.hasErrors()) {
//            System.out.println("Loi");
//        }
//        else {
//            System.out.println("Khong loi");
//            customerEntity.setIdCustomer(SecurityUtil.getPrincipal().getCustomer().getIdCustomer());
//            customerEntity.setPassword(passwordEncoder.encode(customerEntity.getPassword()));
//            customerService.save(customerEntity);
//        }
//        model.addAttribute("myAccount",customerEntity);
//        return "redirect:/myAccount";
//    }

    @RequestMapping("/myAccount/myAccountOrder")
    public String myOrder (Model model){
        model.addAttribute("orderList",orderService.findAll());
        model.addAttribute("detailOrderList",detailOrderService.findAll());
        return "web/myOrder-account";
    }
}
