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
@Table(name = "Type")
public class TypeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idType;

    @Column
    private String nameType;

    @OneToMany(mappedBy = "idType")
    private List<ProductEntity> productEntities;

    public TypeEntity(Long idType, String nameType) {
        this.idType = idType;
        this.nameType = nameType;
    }

    public TypeEntity() {

    }
}
