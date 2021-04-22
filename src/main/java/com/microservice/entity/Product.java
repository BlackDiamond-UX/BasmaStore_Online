package com.microservice.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity(name = "product")
public class Product implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 508162469941495435L;

	@Id
	@GeneratedValue(strategy = GenerationType. IDENTITY)
	private Long productId;
	
	@Column(nullable=false, length = 50)
	private String productName;
	@Column(nullable=false)
	private Float price;
	@Column(nullable=false)
	private int quantity;
	
	
	
	 public Long getProductId() {
		return productId;
	}



	public void setProductId(Long productId) {
		this.productId = productId;
	}



	public String getProductName() {
		return productName;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}



	public Float getPrice() {
		return price;
	}



	public void setPrice(Float price) {
		this.price = price;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	@Override
	    public String toString(){  
	        return "Product{"+
	        "  productId=" + productId + 
	        ", productName='"+ productName + '\'' + 
	        ", price=" + price+
	        ", quantity='"+ quantity + '\'' + 
	        '}';
	    }
}
    
