package com.example.bassmaonline.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "commande")

public class CommandeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long orderId;

    private String orderDate;

    private String codePostal;

    private String totalOrder;

    private String adresse;

    private String CodePromoId;



    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getTotalOrder() {
        return totalOrder;
    }

    public void setTotalOrder(String totalOrder) {
        this.totalOrder = totalOrder;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePromoId() {
        return CodePromoId;
    }

    public void setCodePromoId(String codePromoId) {
        CodePromoId = codePromoId;
    }


   // private Long orderId;

    //@NotNull
    //private String orderDate;
    //@NotNull
    //private String codePostal;
    //@NotNull
    //private String totalOrder;
    //@NotNull
    //private String adresse;
    //@NotNull
    //private String CodePromo;
}
