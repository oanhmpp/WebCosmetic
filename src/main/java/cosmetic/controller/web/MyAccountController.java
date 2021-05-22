package cosmetic.controller.web;

import cosmetic.entity.CustomerEntity;
import cosmetic.repository.CustomerRespository;
import cosmetic.repository.DetailOrderRepository;
import cosmetic.repository.OrderRepository;
import cosmetic.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyAccountController {

    @Autowired
    CustomerRespository customerRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    DetailOrderRepository detailOrderRepository;

    @RequestMapping("/myAccount")
    public String myAccount(Model model){
        CustomerEntity customerEntity = customerRepository.findOneByEmail(SecurityUtil.getPrincipal().getUsername());
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
//            customerEntity.setIdCustomer(SecurityUtil.getPrincipal().getCustomer().getIdCustomer());
//            customerEntity.setPassword(passwordEncoder.encode(customerEntity.getPassword()));
//            customerRepository.save(customerEntity);
//        }
//        model.addAttribute("myAccount",customerEntity);
//        return "redirect:/myAccount";
//    }

    @RequestMapping("/myAccount/myAccountOrder")
    public String myOrder (Model model){
        model.addAttribute("orderList",orderRepository.findAll());
        model.addAttribute("detailOrderList",detailOrderRepository.findAll());
        return "web/myOrder-account";
    }
}
