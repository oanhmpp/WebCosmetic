package cosmetic.repository;

import cosmetic.entity.CustomerEntity;
import cosmetic.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRespository  extends JpaRepository<CustomerEntity, Long> {
    Optional<CustomerEntity> findByEmail(String email);
    CustomerEntity getUserByNameCustomer(String userName);
}