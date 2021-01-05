package cosmetic.controller.admin;

import cosmetic.entity.ProductEntity;
import cosmetic.service.ProductServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class editProductController {

    @Autowired
    private ProductServer productService;

    @RequestMapping("/admin/editProduct")
    public String editProduct(Model model, @RequestParam String idProduct){
        model.addAttribute("product",productService.findOneById(idProduct));
        return "admin/editProduct";
    }
}
