package cosmetic.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
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
//    @NotBlank
//    @NotEmpty(message = "Description not null")
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JsonIgnore
    @JoinColumn(name = "idProduct")
    private ProductEntity productEntity;

    public DetailProductEntity() {

    }
}
