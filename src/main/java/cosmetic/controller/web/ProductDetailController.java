package cosmetic.controller.web;

import cosmetic.entity.DetailProductEntity;
import cosmetic.entity.OrdersEntity;
import cosmetic.entity.ProductEntity;
import cosmetic.repository.ProductDetailRepository;
import cosmetic.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductDetailController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductDetailRepository productDetailRepository;

    @RequestMapping("/productDetail")
    public String productDetail(Model model, @RequestParam Long idProduct){
        ProductEntity productEntity = productRepository.findById(idProduct).get();
        DetailProductEntity detailProduct =  productDetailRepository.findById(idProduct).get();
        model.addAttribute("product", productEntity);
        model.addAttribute("productDetail", detailProduct);

        model.addAttribute("productRandom",productRepository.findByRandomPro());

        String img = detailProduct.getImage();
        String[] arrImg = img.split("~");

        model.addAttribute("arrImg",arrImg);

        model.addAttribute("order",new OrdersEntity());

        return "web/product-detail";
    }

}
