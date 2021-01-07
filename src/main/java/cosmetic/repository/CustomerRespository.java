package cosmetic.repository;

import cosmetic.entity.CustomerEntity;
import cosmetic.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRespository  extends JpaRepository<CustomerEntity, Long> {

}