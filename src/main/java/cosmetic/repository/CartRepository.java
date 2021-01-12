package cosmetic.repository;

import cosmetic.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<CartEntity, Long> {
    int countAllByCustomerEntity_Email(String email);

    CartEntity findOneByProductEntity_IdProduct(Long id);

    List<CartEntity> findALlByCustomerEntity_IdCustomer(Long id);

}