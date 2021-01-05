package cosmetic.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "Customer")
public class CustomerEntity implements Serializable {
    @Id
    private String idCustomer;

    @Column
    private String nameCustomer;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private int role;

    @ManyToMany(mappedBy = "customerEntities")
    private List<OrdersEntity> orderEntities;

    public CustomerEntity() {

    }

}
