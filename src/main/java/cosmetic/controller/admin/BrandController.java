package cosmetic.controller.admin;

import cosmetic.entity.BrandEntity;
import cosmetic.entity.ProductEntity;
import cosmetic.service.BrandServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("admin/brand")

public class BrandController {

    @Autowired
    private BrandServer brandServer;

    @RequestMapping("list")
    private String listBrand(Model model){
        model.addAttribute("listBrand", brandServer.findAll());
        return "/admin/listBrand";
    }

    @RequestMapping("edit")
//    @RequestMapping("/admin/product/edit")
    public String editProduct(Model model, @RequestParam String idBrand) {
        BrandEntity brandEntity = brandServer.findOneById(idBrand);

        model.addAttribute("brand", brandEntity);

        return "admin/editBrand";
    }

    @PostMapping("edit")
    public String edited(Model model, @Valid @ModelAttribute("brand") BrandEntity brandEntity) {
        brandServer.save(brandEntity);
        return "redirect:/admin/brand/list";
    }

    @GetMapping("delete")
    public String delete(Model model, @RequestParam String idProduct) {
        brandServer.delete(idProduct);
        return "redirect:/admin/brand/list";
    }

    @RequestMapping("add")
    public String add(Model model) {
        model.addAttribute("brand", new BrandEntity());
        return "admin/addBrand";
    }
//
//    @PostMapping("added")
//    public String added(Model model, @Valid @ModelAttribute("product") ProductEntity productEntity) {
//        productEntity.getDetailProductEntity().setProductEntity(productEntity);
//        productService.save(productEntity);
//        return "redirect:/admin/product/list";
//    }

}
