package com.example.bassmaonline.Controller;


import com.example.bassmaonline.entity.ProductsEntity;
import com.example.bassmaonline.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductsController {


    @Autowired
    ProductsService productsService;

    @PostMapping
    public ResponseEntity<ProductsEntity> createProducts(@RequestBody ProductsEntity productsEntity)
    {
        ProductsEntity products=productsService.createProducts(productsEntity);
        return new ResponseEntity<ProductsEntity>(products, HttpStatus.CREATED);
    }


    @PutMapping(path="/{productId}")
    public ResponseEntity<ProductsEntity> UpdateProducts(@RequestBody ProductsEntity productsEntity,@PathVariable Long productId)
    {
        ProductsEntity products=productsService.updateProducts(productId,productsEntity);
        return new ResponseEntity<>(products,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/RemoveProd/{idProd}")
    public ResponseEntity<ProductsEntity> removeProducts(@PathVariable Long idProd)
    {
        productsService.deleteProducts(idProd);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<ProductsEntity> getAllProducts()
    {
        List<ProductsEntity> products=productsService.getProducts();
        return new ResponseEntity(products, HttpStatus.OK);
    }
    @GetMapping
    public List<ProductsEntity> listProducts() {
        return  productsService.getProducts();
    }
}
