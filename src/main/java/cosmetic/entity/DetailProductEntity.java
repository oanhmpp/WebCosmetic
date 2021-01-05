package cosmetic.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "DetailProduct")
public class DetailProductEntity implements Serializable {

    @Id
    private String idProduct ;

    @Column
    private String image;

    @Column
    private String description;

    @OneToOne
    @MapsId
    @JoinColumn(name = "idProduct")
    private ProductEntity productEntity;

    public DetailProductEntity() {

    }
}
