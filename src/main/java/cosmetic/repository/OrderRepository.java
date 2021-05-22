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

    @Query(nativeQuery = true, value = "SELECT brand.nameBrand, sum(de_o.amount) FROM \n" +
            "`detailorder` de_o\n" +
            "join product pro on pro.idProduct = de_o.idProduct\n" +
            "join brand on brand.idBrand = pro.idBrand\n" +
            "join oders on oders.idOrder = de_o.idOrder\n" +
            "where pro.idProduct = de_o.idProduct and oders.date BETWEEN ?1 AND ?2 \n" +
            "GROUP BY brand.nameBrand")
    List<?> salesByBrand(String year1, String year2);

    @Query(nativeQuery = true, value = "SELECT MONTH(date), SUM(amount) FROM detailorder join oders on detailorder.idOrder=oders.idOrder WHERE YEAR(date)=?1 GROUP BY MONTH(date) ORDER BY MONTH(date) ASC")
    List<?> salesByYear(String year);
    @Query(nativeQuery = true, value = "SELECT brand.nameBrand, sum(de_o.price) FROM  `detailorder` de_o join product pro on pro.idProduct = de_o.idProduct join brand on brand.idBrand = pro.idBrand join oders on oders.idOrder = de_o.idOrder where pro.idProduct = de_o.idProduct and oders.date BETWEEN ?1 AND ?2  GROUP BY brand.nameBrand")
    List<?> revenueByBrand(String year1, String year2);

    OrdersEntity findOneByIdOrder(Long id);

}
