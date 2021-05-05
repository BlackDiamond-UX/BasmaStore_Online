package com.example.bassmaonline.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pictures")
public class PicturesEntity implements Serializable {
    private static long serialVersionUID;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPict;
    private String NamePic;
    private String path;

    @ManyToOne
    @JoinColumn(name = "Prod_id")
    private ProductsEntity productsEntity;

    public Long getIdPict() {
        return idPict;
    }

    public void setIdPict(Long idPict) {
        this.idPict = idPict;
    }

    public String getNamePic() {
        return NamePic;
    }

    public void setNamePic(String namePic) {
        NamePic = namePic;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ProductsEntity getProductsEntity() {
        return productsEntity;
    }

    public void setProductsEntity(ProductsEntity productsEntity) {
        this.productsEntity = productsEntity;
    }
}
