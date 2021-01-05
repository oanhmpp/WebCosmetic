package cosmetic.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "Brand")
public class BrandEntity {

    @Id
    private String idBrand;

    @Column
    private String nameBrand;

    @OneToMany(mappedBy = "idBrand")
    private List<ProductEntity> productEntities;

    public BrandEntity(String idBrand, String nameBrand) {
        this.idBrand = idBrand;
        this.nameBrand = nameBrand;
    }

    public BrandEntity() {

    }

}