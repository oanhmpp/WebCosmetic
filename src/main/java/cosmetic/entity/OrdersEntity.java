package cosmetic.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Oders")
@Data
public class OrdersEntity {
    @Id
    private String idOrder;

    private  String address;

    private double totalPrice;

    private int phone;

        @OneToMany(mappedBy = "order")
    private List<DetailOrderEntity> detailOrderEntities;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "idOrder"),
            inverseJoinColumns = @JoinColumn(name = "idCustomer"))
    private List<CustomerEntity> customerEntities;

}
