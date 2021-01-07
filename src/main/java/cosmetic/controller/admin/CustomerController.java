package cosmetic.controller.admin;

import cosmetic.entity.BrandEntity;
import cosmetic.entity.CustomerEntity;
import cosmetic.service.BrandService;
import cosmetic.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("admin/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("list")
    private String listBrand(Model model){
        model.addAttribute("listCus", customerService.findAll());
        return "/admin/listCus";
    }

    @RequestMapping("edit")
//    @RequestMapping("/admin/product/edit")
    public String editProduct(Model model, @RequestParam Long id) {
        CustomerEntity customerEntity = customerService.findOneById(id);

        model.addAttribute("customer", customerEntity);

        return "admin/editCus";
    }

    @PostMapping("edit")
    public String edited(Model model, @Valid @ModelAttribute("customer") CustomerEntity customerEntity) {
        customerService.save(customerEntity);
        return "redirect:/admin/customer/list";
    }

    @GetMapping("delete")
    public String delete(Model model, @RequestParam Long id) {
        customerService.delete(id);
        return "redirect:/admin/customer/list";
    }

    @RequestMapping("add")
    public String add(Model model) {
        model.addAttribute("customer", new CustomerEntity());
        return "admin/addCus";
    }

    @PostMapping("added")
    public String added(Model model, @Valid @ModelAttribute("customer") CustomerEntity customerEntity) {
        customerService.save(customerEntity);
        return "redirect:/admin/customer/list";
    }
}
