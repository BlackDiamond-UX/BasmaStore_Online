package com.microservice.dao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.microservice.entity.Product;
import com.microservice.repositories.ProductRepository;


@Repository
public  class ProductDaoImpl implements ProductService {
	@Autowired
	ProductRepository productRepository;
	
	Product product;
	@Override
	public Product createProduct(Product product) {
		Product newProduct = productRepository.save(product);
		return newProduct;
	}
	@Override
	public List<Product> getProduct(String recherche) {
		// TODO Auto-generated method stub
		List<Product> product = productRepository.findByProductNameLike("%"+recherche+"%");
		if (product == null)
			System.out.println("Product Not Found!");
		return product;
	}

	@Override
	public Product deleteProduct(Long productId) {
		Product product = productRepository.findByProductId(productId);
		//if (userEntity == null) throw new UsernameNotFoundException(userId);
		productRepository.delete(product);
		return product;
	}
	
	@Override
	public Product updateProduct(Long productId, Product product) {
		Product productp = productRepository.findByProductId(productId);
		productp.setProductName(productp.getProductName());
		productp.setPrice(productp.getPrice());
		productp.setQuantity(productp.getQuantity());
		Product productUpdate = productRepository.save(productp);
		return productUpdate;
	}

	@Override
	public Product getProdcutById(Long productId) {
		// TODO Auto-generated method stub
				Product product = productRepository.findByProductId(productId);
				if (product == null)
					System.out.println("Product Not Found!");
				return product;
	}
	@Override
	public List<Product> getProducts() {
		List<Product> products = productRepository.findAll();
		return products;
	}

}