package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.example.demo.entity.Customer;

@Mapper
public interface CustomerMapper {
    List<Customer> findAll();

    Customer findById(int id);

    int insert(Customer customer);

    int deleteById(int id);

    int update(Customer customer);
}
