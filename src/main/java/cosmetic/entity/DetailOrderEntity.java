package cosmetic.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "DetailOrder")

public class DetailOrderEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nameProduct;

    @Column
    private int amount;

    @Column
    private double price;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "idOrder")
    private OrdersEntity order;

    public DetailOrderEntity() {

    }
}
