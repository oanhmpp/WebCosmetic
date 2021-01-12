package cosmetic.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
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
    @JoinColumn(name = "idBrand", nullable = false)
    private BrandEntity idBrand;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            joinColumns = @JoinColumn(name = "idProduct"),
            inverseJoinColumns = @JoinColumn(name = "idType"))
    @Fetch(value = FetchMode.SUBSELECT)
//    @JoinColumn(name = "idType", nullable = false)
    private List<TypeEntity> idType;

    @Column
    private String image;

    @Column
    private String nameProduct;

    @Column
    private double price;

    // so luong san pham
    @Column
    private int amount;

    @Column
    private int active;

    @OneToOne(mappedBy = "productEntity", cascade = CascadeType.ALL)
    private DetailProductEntity detailProductEntity;

//    @Transient
//    private MultipartFile fileImageProduct;


}
