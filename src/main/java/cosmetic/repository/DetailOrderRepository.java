package cosmetic.repository;

import cosmetic.entity.DetailOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DetailOrderRepository extends JpaRepository<DetailOrderEntity,Long> {

    List<DetailOrderEntity> findByOrder_IdOrder(Long id);

    @Query(nativeQuery = true, value = "DELETE FROM  detailorder WHERE detailorder.idOrder = ?1")
    int deleteByIdOrder(int idOrder);
}
