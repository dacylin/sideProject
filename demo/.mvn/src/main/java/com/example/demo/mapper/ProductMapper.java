package com.example.demo.mapper;

import com.example.demo.entity.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    List<Product> getAllProducts();

    Product getProductById(Integer productsid);

    int insertProduct(Product product);

    int updateProduct(Product product);

    int deleteProduct(Integer productsid);
}
