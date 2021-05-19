package cosmetic.repository;

import cosmetic.entity.OrdersEntity;
import cosmetic.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface OrderRepository extends JpaRepository<OrdersEntity, Long> {
    @Query(nativeQuery = true, value = "SELECT DISTINCT YEAR(date) FROM oders;")
    List<Integer> findYear();

    @Query(nativeQuery = true, value = "SELECT MONTH(date), SUM(totalPrice) FROM oders WHERE YEAR(date)=?1 GROUP BY MONTH(date) ORDER BY MONTH(date) ASC")
    List<?> revenueByYear(String year);
}
