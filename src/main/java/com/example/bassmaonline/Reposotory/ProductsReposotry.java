package com.example.bassmaonline.Reposotory;

import com.example.bassmaonline.entity.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsReposotry extends JpaRepository<ProductsEntity, Long> {
    ProductsEntity findByIdProd(Long id);
}
