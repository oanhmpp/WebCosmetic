package cosmetic.controller.admin;

import cosmetic.entity.TypeEntity;
import cosmetic.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("admin/type")

public class TypeController {
    @Autowired
    private TypeService typeService;

    @RequestMapping("list")
    private String listBrand(Model model){
        model.addAttribute("listType", typeService.findAll());
        return "/admin/listType";
    }

    @RequestMapping("edit")
//    @RequestMapping("/admin/product/edit")
    public String editProduct(Model model, @RequestParam String idType) {
        TypeEntity typeEntity = typeService.findOneById(idType).get();

        model.addAttribute("type", typeEntity);

        return "admin/editType";
    }

    @PostMapping("edit")
    public String edited(Model model, @Valid @ModelAttribute("type") TypeEntity typeEntity) {
        typeService.save(typeEntity);
        return "redirect:/admin/type/list";
    }

    @GetMapping("delete")
    public String delete(Model model, @RequestParam String idType) {
        typeService.delete(idType);
        return "redirect:/admin/type/list";
    }

    @RequestMapping("add")
    public String add(Model model) {
        model.addAttribute("type", new TypeEntity());
        return "admin/addType";
    }

    @RequestMapping("checkId")
    public @ResponseBody boolean checkId (@RequestParam("id") String id){
        System.out.println(id);
        Optional<TypeEntity>  typeEntity = typeService.findOneById(id);
        if(typeEntity.isPresent()) {
            return false;
        }
        return true;

    }

    @PostMapping("added")
    public String added(Model model, @Valid @ModelAttribute("type") TypeEntity typeEntity) {
        typeService.save(typeEntity);
        return "redirect:/admin/type/list";
    }

}
