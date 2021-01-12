package cosmetic.controller.web;


import cosmetic.entity.CartEntity;
import cosmetic.entity.CustomerEntity;
import cosmetic.entity.MyCustomerDetails;
import cosmetic.entity.ProductEntity;
import cosmetic.service.CartService;
import cosmetic.service.CustomerService;
import cosmetic.service.ProductDetailService;
import cosmetic.service.ProductService;
import cosmetic.until.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller

public class CartController {

    @Autowired
    ProductDetailService productDetailService;
    @Autowired
    ProductService productService;
    @Autowired
    CartService cartService;
    @Autowired
    CustomerService customerService;

    @RequestMapping("/buyNow")
    public @ResponseBody
    boolean buyNow(Model model, @RequestParam("idProduct") Long idProduct) {
        if (SecurityUtil.getPrincipal() != null) {
            System.out.println("da dang nhap");
            return true;
        } else {
            System.out.println("You need to login");
            return false;
        }
    }

    @RequestMapping("/cart")
    public String cart(Model model) {
        CustomerEntity customerEntity = customerService.findOneByEmail(SecurityUtil.getPrincipal().getUsername());
        List<CartEntity> cartEntities = cartService.findByCustomerEntity_Id(customerEntity.getIdCustomer());
        model.addAttribute("cart", cartEntities);
        return "web/cart";
    }

    @RequestMapping("/getSize")
    public @ResponseBody
    int getSize() {
        if (SecurityUtil.getPrincipal() != null) {
            String mail = SecurityUtil.getPrincipal().getUsername();
            return cartService.getSize(mail);
        }
        return 0;
    }

    @RequestMapping("/addToCart")
    public @ResponseBody
    String addToCart(CartEntity cartEntity, ProductEntity productEntity, @RequestParam("idProduct") Long idProduct) {
        if (SecurityUtil.getPrincipal() != null) {
            CustomerEntity customerEntity = customerService.findOneByEmail(SecurityUtil.getPrincipal().getUsername());
            productEntity.setIdProduct(idProduct);
            cartEntity.setProductEntity(productEntity);
            cartEntity.setCustomerEntity(customerEntity);
            CartEntity entity = cartService.findOneByProductEntity_IdProduct(idProduct);
            if (entity == null) {
                cartEntity.setNumber(1);
            } else {
                cartEntity = entity;
                cartEntity.setNumber(cartEntity.getNumber() + 1);
            }
            cartService.save(cartEntity);
            return " Added to cart";
        } else {
            return "Error adding product";
        }
    }

    // nut tang
    @GetMapping("/increase")
    public @ResponseBody String increase (@RequestParam("id") Long id){
        CartEntity cartEntity = cartService.findOneById(id);
        System.out.println("-----------sss---------------");
        System.out.println(cartEntity.getNumber());
        System.out.println("--------------------------");
        cartEntity.setNumber(cartEntity.getNumber()+1);
        cartService.save(cartEntity);
        return "redirect:/cart";
    }

    // nut giam
    @GetMapping("/decrease")
    public @ResponseBody String decrease (@RequestParam("id") Long id){
        CartEntity cartEntity = cartService.findOneById(id);
        System.out.println("-----------sss---------------");
        System.out.println(cartEntity.getNumber());
        System.out.println("--------------------------");
        cartEntity.setNumber(cartEntity.getNumber()-1);
        cartService.save(cartEntity);
        return "redirect:/cart";
    }

    // nut delete
    @GetMapping("/cart/delete")
    public @ResponseBody String delete(@RequestParam("id") Long id){
        cartService.deleteCart(id);
        return "redirect:/cart";
    }
}
