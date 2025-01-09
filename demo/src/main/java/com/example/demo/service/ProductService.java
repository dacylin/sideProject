package com.example.demo.service;

import com.example.demo.entity.Product;
import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getProductById(int id);

    void addProduct(Product product);

    void deleteProductById(int id);

    void updateProduct(Product product);
}
