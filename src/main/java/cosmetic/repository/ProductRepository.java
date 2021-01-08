package cosmetic.repository;

import cosmetic.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM product ORDER BY RAND() LIMIT 7")
    List<ProductEntity> findByRandomPro();
}
