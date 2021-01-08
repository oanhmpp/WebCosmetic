package cosmetic.repository;

import cosmetic.entity.DetailProductEntity;
import cosmetic.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDetailRepository extends JpaRepository<DetailProductEntity, Long> {

}
