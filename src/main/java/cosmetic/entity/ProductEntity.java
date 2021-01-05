package cosmetic.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "Product")
public class ProductEntity implements Serializable {
    @Id
    private String idProduct;

//    @Column
//    private String idBrand;

//    @Column
//    private String idType;

    @Column
    private String image;

    @Column
    private String nameProduct;

    @Column
    private double price;

    // so luong san pham
    @Column
    private double amount;

    @ManyToOne
    @JoinColumn(name = "idBrand",nullable = false)
    private BrandEntity idBrand;

    @ManyToOne
    @JoinColumn(name = "idType", nullable = false)
    private TypeEntity idType;

    public ProductEntity() {

    }

}
