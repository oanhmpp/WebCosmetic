package cosmetic.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "Product")
public class ProductEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "idBrand", nullable = false)
    private BrandEntity idBrand;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            joinColumns = @JoinColumn(name = "idProduct"),
            inverseJoinColumns = @JoinColumn(name = "idType"))
    @Fetch(value = FetchMode.SUBSELECT)
    private List<TypeEntity> idType;

    @Column
    private String image;

    @Column
//    @Length(min = 5)
//    @NotNull(message = "Name product not null !!")
    private String nameProduct;

    @Column
//    @NotNull(message = "Price not null !!")
    private double price;

    // so luong san pham
    @Column
//    @NotBlank
//    @NotEmpty(message = "Number product is not null")
    private int amount;

    @Column
    private int active;
    @JsonIgnore
    @OneToOne(mappedBy = "productEntity", cascade = CascadeType.ALL)
    private DetailProductEntity detailProductEntity;

//    @Transient
//    private MultipartFile fileImageProduct;


}
