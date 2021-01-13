package cosmetic.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "Brand")
public class BrandEntity {

    @Id
    private String idBrand;

    @Column
    private String nameBrand;

    @OneToMany(mappedBy = "idBrand")
    @JsonIgnore
    private List<ProductEntity> productEntities;

    public BrandEntity(String idBrand, String nameBrand) {
        this.idBrand = idBrand;
        this.nameBrand = nameBrand;
    }

    public BrandEntity() {

    }

}
