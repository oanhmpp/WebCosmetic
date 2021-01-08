package cosmetic.repository;

import cosmetic.entity.DetailProductEntity;
import cosmetic.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDetailRepository extends JpaRepository<DetailProductEntity, Long> {

}
