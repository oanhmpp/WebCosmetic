package cosmetic.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "Product")
public class ProductEntity implements Serializable {
    @Id
    private String idProduct;

    @ManyToOne
    @JoinColumn(name = "idBrand",nullable = false)
    private BrandEntity idBrand;

    @ManyToOne
    @JoinColumn(name = "idType", nullable = false)
    private TypeEntity idType;

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
    private int  active;

    @OneToOne(mappedBy = "productEntity")
    private DetailProductEntity detailProductEntity;

    public ProductEntity() {

    }


}
