package cosmetic.controller.admin;

import cosmetic.entity.BrandEntity;
import cosmetic.entity.ProductEntity;
import cosmetic.service.BrandService;
import cosmetic.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("admin/brand")

public class BrandController {

    @Autowired
    private BrandService brandServer;

    @RequestMapping("list")
    private String listBrand(Model model){
        model.addAttribute("listBrand", brandServer.findAll());
        return "/admin/listBrand";
    }

    @RequestMapping("edit")
//    @RequestMapping("/admin/product/edit")
    public String editProduct(Model model, @RequestParam String idBrand) {
        BrandEntity brandEntity = brandServer.findOneById(idBrand).get();

        model.addAttribute("brand", brandEntity);

        return "admin/editBrand";
    }

    @PostMapping("edit")
    public String edited(Model model, @Valid @ModelAttribute("brand") BrandEntity brandEntity) {
        brandServer.save(brandEntity);
        return "redirect:/admin/brand/list";
    }

    @GetMapping("delete")
    public String delete(Model model, @RequestParam String idBrand) {
        brandServer.delete(idBrand);
        return "redirect:/admin/brand/list";
    }

    @RequestMapping("add")
    public String add(Model model) {
        model.addAttribute("brand", new BrandEntity());
        return "admin/addBrand";
    }

    @RequestMapping("checkId")
    public @ResponseBody boolean checkId (@RequestParam("id") String id){
        System.out.println(id);
        Optional<BrandEntity> brandEntity = brandServer.findOneById(id);
        if(brandEntity.isPresent()) {
            return false;
        }
            return true;

    }

    @PostMapping("added")
    public String added(Model model, @Valid @ModelAttribute("brand") BrandEntity brandEntity) {
        brandServer.save(brandEntity);
        return "redirect:/admin/brand/list";
    }

}
