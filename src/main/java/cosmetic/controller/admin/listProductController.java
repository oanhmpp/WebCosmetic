package cosmetic.controller.admin;

import cosmetic.entity.BrandEntity;
import cosmetic.entity.ProductEntity;
import cosmetic.entity.TypeEntity;
import cosmetic.service.ProductServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class listProductController {
    @Autowired
    private ProductServer productService;

    @RequestMapping("/admin/listProduct")
    public String listProduct(Model model){
        model.addAttribute("listProduct", productService.findAll());
        return "admin/listProduct";
    }
}
