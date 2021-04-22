package com.microservice.dao;

import java.util.List;
import com.microservice.entity.*;

public interface ProductService {

    public Product createProduct(Product product);
	
	public List<Product> getProduct(String recherche);
	
	public Product getProdcutById(Long productId);
	
	public Product updateProduct(Long id, Product product);
	
	public Product deleteProduct(Long productId);

	public List<Product> getProducts();
}
