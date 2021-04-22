package com.microservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.microservice.entity.*;

public interface ProductRepository extends JpaRepository<Product,Long> {

	Product findByProductId(Long productId);
	List<Product> findByProductNameLike(String recherche);
}
