package cosmetic.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "Role")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRole;

    @Column
    private String nameRole;

    @ManyToMany(mappedBy = "roleEntityList")
    private List<CustomerEntity> customerEntities;
}
