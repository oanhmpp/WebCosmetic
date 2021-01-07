package cosmetic.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "DetailProduct")
public class DetailProductEntity implements Serializable {

    @Id
    private Long idProduct;

    @Column
    private String image;

    @Column
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "idProduct")
    private ProductEntity productEntity;

    public DetailProductEntity() {

    }
}
