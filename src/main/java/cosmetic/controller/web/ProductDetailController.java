package cosmetic.controller.web;

import cosmetic.entity.DetailProductEntity;
import cosmetic.entity.OrdersEntity;
import cosmetic.entity.ProductEntity;
import cosmetic.service.ProductDetailService;
import cosmetic.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductDetailController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductDetailService productDetailService;

    @RequestMapping("/productDetail")
    public String productDetail(Model model, @RequestParam Long idProduct){
        ProductEntity productEntity = productService.findOneById(idProduct);
        DetailProductEntity detailProduct =  productDetailService.findOneById(idProduct);
        model.addAttribute("product", productEntity);
        model.addAttribute("productDetail", detailProduct);

        String img = detailProduct.getImage();
        String[] arrImg = img.split("~");

        model.addAttribute("arrImg",arrImg);

        model.addAttribute("order",new OrdersEntity());

        model.addAttribute("listProByName",productService.findOneByName(productEntity.getNameProduct()));

        return "web/product-detail";
    }

}
