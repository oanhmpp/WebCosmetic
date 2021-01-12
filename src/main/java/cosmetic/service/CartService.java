package cosmetic.service;

import cosmetic.entity.CartEntity;
import cosmetic.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;

    public void save(CartEntity cartEntity){
        cartRepository.save(cartEntity);
    }

    public int getSize (String mail){ return cartRepository.countAllByCustomerEntity_Email(mail);
    }

    public CartEntity findOneByProductEntity_IdProduct(Long id) {
        return  cartRepository.findOneByProductEntity_IdProduct(id);
    }

    public List<CartEntity> findByCustomerEntity_Id(Long id){
        return cartRepository.findALlByCustomerEntity_IdCustomer(id);
    }

    public CartEntity findOneById (Long id){
        return cartRepository.findById(id).get();
    }

    public void deleteCart(Long id){
        cartRepository.deleteById(id);
    }
}
