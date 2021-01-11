package cosmetic.repository;

import cosmetic.entity.CustomerEntity;
import cosmetic.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRespository  extends JpaRepository<CustomerEntity, Long> {
    List<CustomerEntity>  findByEmail(String email);
    CustomerEntity getCustomerEntityByEmail(String userName);

}