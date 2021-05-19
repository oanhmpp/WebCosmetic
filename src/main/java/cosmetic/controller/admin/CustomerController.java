package cosmetic.controller.admin;

import cosmetic.entity.CustomerEntity;
import cosmetic.repository.CustomerRespository;
import cosmetic.validator.CustomerValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("admin/customer")
public class CustomerController {

    @Autowired
    private CustomerRespository customerRepository;

    @RequestMapping("list")
    private String listCus(Model model){
        model.addAttribute("listCus", customerRepository.findAll());
        return "/admin/listCus";
    }

    @RequestMapping("edit")
//    @RequestMapping("/admin/product/edit")
    public String editCustomer(Model model, @RequestParam Long id) {
        CustomerEntity customerEntity = customerRepository.findById(id).get();

        model.addAttribute("customer", customerEntity);

        return "admin/editCus";
    }

    @PostMapping("edit")
    public String edited(Model model,
                         @Valid @ModelAttribute("customer") CustomerEntity customerEntity,
                         CustomerValidate customerValidate,
                         BindingResult result) {
        customerValidate.validateAdmin(customerEntity,result);
        if (result.hasErrors()) {
            System.out.println("Loi");
            return "/admin/editCus";
        }
        else {
            customerRepository.save(customerEntity);
            return "redirect:/admin/customer/list";
        }
    }

    @GetMapping("delete")
    public String delete(Model model, @RequestParam Long id) {
        customerRepository.deleteById(id);
        return "redirect:/admin/customer/list";
    }

    @RequestMapping("add")
    public String add(Model model) {
        model.addAttribute("customer", new CustomerEntity());
        return "admin/addCus";
    }

    @PostMapping("add")
    public String added(Model model, CustomerValidate customerValidate,
                        @Valid @ModelAttribute("customer") CustomerEntity customerEntity,
                        BindingResult result) {
//        customerValidate.validateExist(customerEntity, result, customerRepository.findByEmail(customerEntity.getEmail()).isEmpty());
        customerValidate.validate(customerEntity,result);
        if (result.hasErrors()) {
            System.out.println("Loi");
            return "/admin/addCus";
        }
        else {
            customerRepository.save(customerEntity);
            return "redirect:/admin/customer/list";
        }
    }

    @RequestMapping("checkEmail")
    public @ResponseBody boolean checkEmail(CustomerValidate customerValidate,
                             @Valid @ModelAttribute("customer") CustomerEntity customerEntity,
                             BindingResult result,
                             @RequestParam("email") String email){
        System.out.println(email);
        List<CustomerEntity> check = customerRepository.findByEmail(email);
        if(check.isEmpty()){
            return true;
        }
        else {
           return false;
        }
    }
}
