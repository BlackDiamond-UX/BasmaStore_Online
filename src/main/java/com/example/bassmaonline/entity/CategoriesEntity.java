package com.example.bassmaonline.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name=" categories")
public class CategoriesEntity implements Serializable {

    private static long serialVersionUID;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCat;

    @NotNull
    private String NameCat;

    @NotNull
    private String Picture;

    @OneToMany(mappedBy = "categoriesEntity",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ProductsEntity> product;


    public CategoriesEntity()
    {

    }

    public CategoriesEntity(String nameCat, String picture) {
        NameCat = nameCat;
        Picture = picture;

    }

    public Long getIdCat() {
        return idCat;
    }

    public void setIdCat(Long idCat) {
        this.idCat = idCat;
    }

    public String getNameCat() {
        return NameCat;
    }

    public void setNameCat(String nameCat) {
        NameCat = nameCat;
    }

    public String getPicture() {
        return Picture;
    }

    public void setPicture(String picture) {
        Picture = picture;
    }

    public List<ProductsEntity> getProduct() {
        return product;
    }

    public void setProduct(List<ProductsEntity> product) {
        this.product = product;
    }
}
