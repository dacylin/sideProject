package com.example.demo.service;

import com.example.demo.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(int id);

    void insert(Product product);

    void update(Product product);

    void deleteById(int id);
}
