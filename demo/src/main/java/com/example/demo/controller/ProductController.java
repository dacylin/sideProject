package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{productsid}")
    public Product getProductById(@PathVariable Integer productsid) {
        return productService.getProductById(productsid);
    }

    @PostMapping
    public String insertProduct(@RequestBody Product product) {
        productService.insertProduct(product);
        return "新增產品成功";
    }

    @PutMapping("/{productsid}")
    public String updateProduct(@PathVariable Integer productsid,
            @RequestBody Product product) {
        product.setProductsid(productsid);
        productService.updateProduct(product);
        return "產品修改成功";
    }

    @DeleteMapping("/{productsid}")
    public String deleteProduct(@PathVariable Integer productsid) {
        productService.deleteProduct(productsid);
        return "產品刪除成功";
    }
}
