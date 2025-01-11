package com.example.demo.mapper;

import com.example.demo.entity.Customer;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface CustomerMapper {
    List<Customer> findAll();

    Customer findById(int id);

    void insert(Customer customer);

    void update(Customer customer);

    void deleteById(int id);
}
