package cosmetic.controller.web;

import cosmetic.entity.ProductEntity;
import cosmetic.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller("WebProduct")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping("/product")
    public String product(Model model) {
        model.addAttribute("listProduct", productRepository.findAll());
        return "web/product-list";
    }

    @RequestMapping("searchListProduct")
    public String searchProduct(Model model, @RequestParam("search") String key){
        List<ProductEntity> list = productRepository.search(key);
        model.addAttribute("listProduct", list);
        return "web/product-list";
    }
}
