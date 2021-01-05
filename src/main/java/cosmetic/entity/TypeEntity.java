package cosmetic.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "Type")
public class TypeEntity implements Serializable {

    @Id
    private String idType;

    @Column
    private String nameType;

    @OneToMany(mappedBy = "idType")
    private List<ProductEntity> productEntities;

    public TypeEntity(String idType, String nameType) {
        this.idType = idType;
        this.nameType = nameType;
    }

    public TypeEntity() {

    }
}
