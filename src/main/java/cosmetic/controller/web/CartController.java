package cosmetic.controller.web;


import cosmetic.entity.CartEntity;
import cosmetic.entity.CustomerEntity;
import cosmetic.entity.ProductEntity;
import cosmetic.repository.CartRepository;
import cosmetic.repository.CustomerRespository;
import cosmetic.repository.ProductDetailRepository;
import cosmetic.repository.ProductRepository;
import cosmetic.until.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller

public class CartController {

    @Autowired
    ProductDetailRepository productDetailRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    CustomerRespository customerRepository;

    @GetMapping("/checkLogin")
    public boolean checkLogin (){
        if (SecurityUtil.getPrincipal() != null) {
            return true;
        }else {
            return false;
        }
    }

    @RequestMapping("/cart")
    public String cart(Model model) {
        CustomerEntity customerEntity = customerRepository.findOneByEmail(SecurityUtil.getPrincipal().getUsername());
        List<CartEntity> cartEntities = cartRepository.findALlByCustomerEntity_IdCustomer(customerEntity.getIdCustomer());
        model.addAttribute("cart", cartEntities);
        return "web/cart";
    }

    @RequestMapping("/getSize")
    public @ResponseBody
    int getSize() {
        if (SecurityUtil.getPrincipal() != null) {
            String mail = SecurityUtil.getPrincipal().getUsername();
            return cartRepository.countAllByCustomerEntity_Email(mail);
        }
        return 0;
    }

    @RequestMapping("/addToCart")
    public @ResponseBody
    String addToCart(CartEntity cartEntity, ProductEntity productEntity, @RequestParam("idProduct") Long idProduct) {
        if (SecurityUtil.getPrincipal() != null) {
            CustomerEntity customerEntity = customerRepository.findOneByEmail(SecurityUtil.getPrincipal().getUsername());
            productEntity.setIdProduct(idProduct);
            cartEntity.setProductEntity(productEntity);
            cartEntity.setCustomerEntity(customerEntity);
            CartEntity entity = cartRepository.findByCustomerEntity_IdCustomerAndProductEntity_IdProduct(customerEntity.getIdCustomer(),idProduct);
            if (entity == null) {
                cartEntity.setNumber(1);
            } else {
                cartEntity = entity;
                cartEntity.setNumber(cartEntity.getNumber() + 1);
            }
            cartRepository.save(cartEntity);
            return " Added to cart";
        } else {
            return "You need to login";
        }
    }

    // nut tang
    @GetMapping("/increase")
    public @ResponseBody String increase (@RequestParam("id") Long id){
        CartEntity cartEntity = cartRepository.findById(id).get();
        System.out.println("-----------sss---------------");
        System.out.println(cartEntity.getNumber());
        System.out.println("--------------------------");
        cartEntity.setNumber(cartEntity.getNumber()+1);
        cartRepository.save(cartEntity);
        return "redirect:/cart";
    }

    // nut giam
    @GetMapping("/decrease")
    public @ResponseBody String decrease (@RequestParam("id") Long id){
        CartEntity cartEntity = cartRepository.findById(id).get();
        System.out.println("-----------sss---------------");
        System.out.println(cartEntity.getNumber());
        System.out.println("--------------------------");
        cartEntity.setNumber(cartEntity.getNumber()-1);
        cartRepository.save(cartEntity);
        return "redirect:/cart";
    }

    // nut delete
    @GetMapping("/cart/delete")
    public @ResponseBody String delete(@RequestParam("id") Long id){
        cartRepository.deleteById(id);
        return "redirect:/cart";
    }
}
