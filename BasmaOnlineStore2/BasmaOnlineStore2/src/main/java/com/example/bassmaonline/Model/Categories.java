package com.example.bassmaonline.Model;

import java.io.Serializable;

public class Categories implements Serializable {

    private Long idCat;

    private String NameCat;

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

    private String Picture;




}
