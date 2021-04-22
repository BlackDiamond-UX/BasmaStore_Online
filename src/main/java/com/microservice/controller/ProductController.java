package com.microservice.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.microservice.dao.ProductService;
import com.microservice.entity.Product;
import com.microservice.repositories.ProductRepository;

@RestController
@RequestMapping(value="/Products")
public class ProductController {


	@Autowired
	private ProductRepository productRepository;
	 @Autowired
	    private ProductService service;

	    @PostMapping(value="/addProduct")
	    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
	    	Product product1=service.createProduct(product);
	    	return new ResponseEntity<Product>(product1,HttpStatus.CREATED);
	    }

	    @GetMapping(value="/products")
	    public ResponseEntity<List<Product>> findAllProducts() {
	        	List<Product> product2	=service.getProducts();
	        	return new ResponseEntity<List<Product>>(product2,HttpStatus.LOOP_DETECTED);
	    }

	    @GetMapping(value="/{id}")
	    public ResponseEntity<Product> findProductById(@PathVariable Long id) {
	       Product product3 = service.getProdcutById(id);
	       return new ResponseEntity<Product>(product3,HttpStatus.FOUND);
	    }

	    @GetMapping(value="/product/{recherhce}")
	    public ResponseEntity<List<Product>> findProductByName(@PathVariable String recherhce) {
	        List<Product> product5 = service.getProduct(recherhce);
	        return new ResponseEntity<List<Product>>(product5,HttpStatus.FOUND);
	    }

	    @PutMapping(value="/update/{productId}")
	    public ResponseEntity<Product> updateProduct(@RequestBody Product product,@PathVariable Long productId) {
	    	product.setProductName(product.getProductName());
	    	product.setPrice(product.getPrice());
	    	product.setQuantity(product.getQuantity());
	    	Product product4 =  productRepository.save(product);
	    	return new ResponseEntity<Product>(product4,HttpStatus.OK);
	    }

	    
	    @DeleteMapping(value="/delete/{id}")
	    public ResponseEntity<Product> deleteProduct(@PathVariable Long id) {
	    	Product product = service.deleteProduct(id);
	        return new ResponseEntity<Product>(product,HttpStatus.GONE);
	    }
 }