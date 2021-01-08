package cosmetic.controller.admin;

import cosmetic.entity.ProductEntity;
import cosmetic.entity.TypeEntity;
import cosmetic.service.BrandService;
import cosmetic.service.ProductService;
import cosmetic.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller("AdminProduct")
@RequestMapping("admin/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private BrandService brandService;
    @Autowired
    private TypeService typeService;

    @RequestMapping("list")
    public String listProduct(Model model) {
        model.addAttribute("listProduct", productService.findAll());
        return "admin/listProduct";
    }

    @RequestMapping("edit")
//    @RequestMapping("/admin/product/edit")
    public String editProduct(Model model, @RequestParam Long idProduct) {
        ProductEntity productEntity = productService.findOneById(idProduct);

        model.addAttribute("product", productEntity);
        model.addAttribute("listBrand", brandService.findAll());
        model.addAttribute("listType", typeService.findAll());

        String img = productEntity.getDetailProductEntity().getImage();

        String[] imgArr = img.split("~");

        model.addAttribute("arrImg1", imgArr[0]);
        model.addAttribute("arrImg2", imgArr[1]);
        model.addAttribute("arrImg3", imgArr[2]);

        return "admin/editProduct";
    }

    @PostMapping("edit")
    public String edited(Model model, @Valid @ModelAttribute("product") ProductEntity productEntity) {

        System.out.println("--------------------"+productEntity.getDetailProductEntity().getDescription()+"\n" +
                productEntity.getIdProduct()+"\n"+
                productEntity.getIdBrand().getIdBrand()+"\n"+
                productEntity.getIdType()+"\n"+
                productEntity.getNameProduct()+"\n"+
                productEntity.getImage()+"\n"+
                productEntity.getDetailProductEntity().getImage()+"--------------------");
        productService.save(productEntity);
        return "redirect:/admin/product/list";
    }

    @GetMapping("delete")
    public String delete(Model model, @RequestParam Long idProduct) {
        productService.delete(idProduct);
        return "redirect:/admin/product/list";
    }

    @RequestMapping("add")
    public String add(Model model) {
        model.addAttribute("product", new ProductEntity());
        model.addAttribute("listBrand", brandService.findAll());
        model.addAttribute("listType", typeService.findAll());
        return "admin/addProduct";
    }

    @PostMapping("added")
    public String added(Model model,
                        @Valid @ModelAttribute("product") ProductEntity productEntity,
                        @RequestParam("type") Long[] type) {

//        if(type.length == 0){
//            return "redirect:/admin/product/edit";
//        }
        List<TypeEntity> typeEntityList = typeService.findByIdIn(type);
        productEntity.setIdType(typeEntityList);
        productEntity.getDetailProductEntity().setProductEntity(productEntity);

        productService.save(productEntity);
        return "redirect:/admin/product/list";
    }

}
