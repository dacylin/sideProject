package com.example.demo.mapper;

import com.example.demo.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ProductMapper {
    List<Product> findAll();

    Product findById(int id);

    void insert(Product product);

    void update(Product product);

    void deleteById(int id);
}
