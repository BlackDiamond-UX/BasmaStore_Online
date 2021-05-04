package com.example.bassmaonline.service;

import com.example.bassmaonline.Reposotory.ProductsReposotry;
import com.example.bassmaonline.entity.ProductsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService{

    @Autowired
    ProductsReposotry productsReposotry;

    @Override
    public ProductsEntity createProducts(ProductsEntity productsEntity) {
        return productsReposotry.save(productsEntity);
    }

    @Override
    public ProductsEntity getProducts(Long id) {
        return productsReposotry.findByIdProd(id);
    }

    @Override
    public ProductsEntity updateProducts(Long id, ProductsEntity productsEntity) {
        productsEntity.setIdProd(id);
        return productsReposotry.save(productsEntity);
    }

    @Override
    public void deleteProducts(Long id) {
          try {
              ProductsEntity productsEntity=productsReposotry.findByIdProd(id);
              productsReposotry.delete(productsEntity);
          }
          catch (Exception e)
          {
              e.printStackTrace();
          }
    }

    @Override
    public List<ProductsEntity> getProducts() {
        return productsReposotry.findAll();
    }
}
