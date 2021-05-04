package com.example.bassmaonline.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "panier")
public class PanierEntity  implements Serializable {
    private static long serialVersionUID;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idpanier;


    @ManyToMany
    @JoinTable( name = "T_Products_Panier_Associations",
            joinColumns = @JoinColumn( name = "idpanier" ),
            inverseJoinColumns = @JoinColumn( name = "idProd " ) )
    private List<ProductsEntity>  productsEntityList;

    public Long getIdpanier() {
        return idpanier;
    }

    public void setIdpanier(Long idpanier) {
        this.idpanier = idpanier;
    }

    public List<ProductsEntity> getProductsEntityList() {
        return productsEntityList;
    }

    public void setProductsEntityList(List<ProductsEntity> productsEntityList) {
        this.productsEntityList = productsEntityList;
    }
}
