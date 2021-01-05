package cosmetic.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Table(name = "DetailProduct")
public class DetailProductEntity implements Serializable {

    @Id
    private String idProduct ;

    @Column
    private String image;

    @Column
    private String description;

    public DetailProductEntity(String idProduct, String image, String description) {
        this.idProduct = idProduct;
        this.image = image;
        this.description = description;
    }

    public DetailProductEntity() {

    }
}
