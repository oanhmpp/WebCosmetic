package cosmetic.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Oders")
@Getter
@Setter
public class OrdersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrder;

    private  String address;

    private double totalPrice;

    private int phone;

    @OneToMany(mappedBy = "order")
    @JsonIgnore
    private List<DetailOrderEntity> detailOrderEntities;

    @ManyToOne

    @JsonIgnore
//    @JoinTable(
//            joinColumns = @JoinColumn(name = "idOrder"),
//            inverseJoinColumns = @JoinColumn(name = "idCustomer"))
    private CustomerEntity customerEntity;

}
