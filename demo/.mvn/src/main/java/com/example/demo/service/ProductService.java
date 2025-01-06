package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Product;

public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(Integer productsid);

    void insertProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(Integer productsid);

}
