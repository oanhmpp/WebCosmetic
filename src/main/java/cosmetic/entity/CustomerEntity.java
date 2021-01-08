package cosmetic.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "Customer")
public class CustomerEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCustomer;

    @Column
    private String nameCustomer;

    @Column
    private String email;

    @Column
    private String password;

    @ManyToMany(mappedBy = "customerEntities")
    private List<OrdersEntity> orderEntities;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "idCustomer"),
            inverseJoinColumns = @JoinColumn(name = "idRole"))
    private List<RoleEntity> roleEntityList;

    public CustomerEntity() {

    }



}
