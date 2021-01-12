package cosmetic.repository;

import cosmetic.entity.DetailOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetailOrderRepository extends JpaRepository<DetailOrderEntity,Long> {

    List<DetailOrderEntity> findByOrder_IdOrder(Long id);
}
