package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.example.demo.entity.Product;

@Mapper
public interface ProductMapper {
    List<Product> findAll();

    Product findById(int id);

    int insert(Product product);

    int deleteById(int id);

    int update(Product product);
}
