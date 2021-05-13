package cosmetic.controller.admin;

import cosmetic.entity.TypeEntity;
import cosmetic.repository.TypeRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("admin/type")

public class TypeController {
    @Autowired
    private TypeRespository typeRepository;

    @RequestMapping("list")
    private String listType(Model model){
        model.addAttribute("listType", typeRepository.findAll());
        return "/admin/listType";
    }

    @RequestMapping("edit")
//    @RequestMapping("/admin/product/edit")
    public String editType(Model model, @RequestParam Long idType) {
        TypeEntity typeEntity = typeRepository.findById(idType).get();

        model.addAttribute("type", typeEntity);

        return "admin/editType";
    }

    @PostMapping("edit")
    public String edited(Model model, @Valid @ModelAttribute("type") TypeEntity typeEntity) {
        typeRepository.save(typeEntity);
        return "redirect:/admin/type/list";
    }

    @GetMapping("delete")
    public String delete(Model model, @RequestParam Long idType) {
        typeRepository.deleteById(idType);
        return "redirect:/admin/type/list";
    }

    @RequestMapping("add")
    public String add(Model model) {
        model.addAttribute("type", new TypeEntity());
        return "admin/addType";
    }

    @PostMapping("added")
    public String added(Model model, @Valid @ModelAttribute("type") TypeEntity typeEntity) {
        typeRepository.save(typeEntity);
        return "redirect:/admin/type/list";
    }

}
