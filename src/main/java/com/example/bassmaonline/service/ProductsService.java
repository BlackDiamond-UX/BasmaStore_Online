package com.example.bassmaonline.service;


import com.example.bassmaonline.entity.ProductsEntity;

import java.util.List;

public interface ProductsService {

    ProductsEntity createProducts(ProductsEntity productsEntity);
    ProductsEntity getProducts(Long id);
    ProductsEntity updateProducts(Long id,ProductsEntity productsEntity);
    void deleteProducts(Long id);
    List<ProductsEntity> getProducts();

}
