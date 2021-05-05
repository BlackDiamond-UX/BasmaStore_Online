package com.example.bassmaonline.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="products")
public class ProductsEntity implements Serializable {

    private static long serialVersionUID;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProd;
    private String NameProd;
    private  String DescProd;
    private float price;
    private int quantity;

    @JsonIgnore
    private float buyingprice;

    @ManyToOne
    @JoinColumn(name = "Cat_id")
    private CategoriesEntity categoriesEntity;

    @OneToMany(mappedBy = "productsEntity",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<PicturesEntity> pictures;

    public Long getIdProd() {
        return idProd;
    }

    public void setIdProd(Long idProd) {
        this.idProd = idProd;
    }

    public String getNameProd() {
        return NameProd;
    }

    public void setNameProd(String nameProd) {
        NameProd = nameProd;
    }

    public String getDescProd() {
        return DescProd;
    }

    public void setDescProd(String descProd) {
        DescProd = descProd;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getBuyingprice() {
        return buyingprice;
    }

    public void setBuyingprice(float buyingprice) {
        this.buyingprice = buyingprice;
    }

    public CategoriesEntity getCategoriesEntity() {
        return categoriesEntity;
    }

    public void setCategoriesEntity(CategoriesEntity categoriesEntity) {
        this.categoriesEntity = categoriesEntity;
    }

    public List<PicturesEntity> getPictures() {
        return pictures;
    }

    public void setPictures(List<PicturesEntity> pictures) {
        this.pictures = pictures;
    }
}
