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

//    // tim 1 cartentity theo id productentity
//    public CartEntity findOneByProductEntity_IdProduct(Long id) {
//        return  cartRepository.findOneByProductEntity_IdProduct(id);
//    }

    public CartEntity findByCustomerEntity_IdCustomerAndProductEntity_IdProduct(Long idCus, Long idPro){
        return cartRepository.findByCustomerEntity_IdCustomerAndProductEntity_IdProduct(idCus,idPro);
    }

    // tim 1 ds cartentity theo id customerentity
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
