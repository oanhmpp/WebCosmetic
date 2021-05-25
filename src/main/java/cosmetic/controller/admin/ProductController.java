package cosmetic.controller.admin;

import cosmetic.entity.ProductEntity;
import cosmetic.entity.TypeEntity;
import cosmetic.repository.BrandRepository;
import cosmetic.repository.ProductRepository;
import cosmetic.repository.TypeRespository;
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
    private ProductRepository productRepository;
    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private TypeRespository typeRepository;

    @RequestMapping("list")
    public String listProduct(Model model) {
        model.addAttribute("listProduct", productRepository.findAll());
        return "admin/listProduct";
    }

    @RequestMapping("edit")
//    @RequestMapping("/admin/product/edit")
    public String editProduct(Model model, @RequestParam Long idProduct) {
        ProductEntity productEntity = productRepository.findById(idProduct).get();

        model.addAttribute("product", productEntity);
        model.addAttribute("listBrand", brandRepository.findAll());
        model.addAttribute("listType", typeRepository.findAll());

        String img = productEntity.getDetailProductEntity().getImage();

        String[] imgArr = img.split("~");

        model.addAttribute("arrImg1", imgArr[0]);
        model.addAttribute("arrImg2", imgArr[1]);
        model.addAttribute("arrImg3", imgArr[2]);

        return "admin/editProduct";
    }

    @PostMapping("edit")
    public String edited(Model model, @Valid @ModelAttribute("product") ProductEntity productEntity) {

//        System.out.println("--------------------"+productEntity.getDetailProductEntity().getDescription()+"\n" +
//                productEntity.getIdProduct()+"\n"+
//                productEntity.getIdBrand().getIdBrand()+"\n"+
//                productEntity.getIdType()+"\n"+
//                productEntity.getNameProduct()+"\n"+
//                productEntity.getImage()+"\n"+
//                productEntity.getDetailProductEntity().getImage()+"--------------------");
        productRepository.save(productEntity);
        return "redirect:/admin/product/list";
    }

    @GetMapping("delete")
    public String delete(Model model, @RequestParam Long idProduct) {
        productRepository.deleteById(idProduct);
        return "redirect:/admin/product/list";
    }

    @RequestMapping("add")
    public String add(Model model) {
        model.addAttribute("product", new ProductEntity());
        model.addAttribute("listBrand", brandRepository.findAll());
        model.addAttribute("listType", typeRepository.findAll());
        return "admin/addProduct";
    }

    @PostMapping("added")
    public String added(Model model,
                        @Valid @ModelAttribute("product") ProductEntity productEntity,
                        @RequestParam("type") Long[] type) {

        List<TypeEntity> typeEntityList = typeRepository.findByIdTypeIn(type);
        productEntity.setIdType(typeEntityList);
        productEntity.getDetailProductEntity().setProductEntity(productEntity);

        productRepository.save(productEntity);
        return "redirect:/admin/product/list";
    }

}
