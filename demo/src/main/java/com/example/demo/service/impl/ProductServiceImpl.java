package com.example.demo.service.impl;

import com.example.demo.entity.Product;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public List<Product> getAllProducts() {
        return productMapper.findAll();
    }

    @Override
    public Product getProductById(int id) {
        return productMapper.findById(id);
    }

    @Override
    public void addProduct(Product product) {
        productMapper.insert(product);
    }

    @Override
    public void deleteProductById(int id) {
        productMapper.deleteById(id);
    }

    @Override
    public void updateProduct(Product product) {
        productMapper.update(product);
    }
}
