package com.microservice.JUnitTesting;

import org.junit.*;
import org.junit.jupiter.api.Test;

import com.microservice.dao.ProductDaoImpl;
import com.microservice.dao.ProductService;
import com.microservice.entity.Product;

public class JUnitTest {

	@Test
	public void test()
	{
		
		ProductService productS = new ProductDaoImpl();
		Product product = new Product();
		product.setPrice((float) 12.2);
		product.setProductName("champo");
		product.setQuantity(2);
		productS.createProduct(product);
	 	
	}
	@Before
	public void addProduct()
	{
		
	}
}
