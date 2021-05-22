package cosmetic.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
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

    private String state;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date date;

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
