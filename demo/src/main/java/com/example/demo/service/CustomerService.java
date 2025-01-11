package com.example.demo.service;

import com.example.demo.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer findById(int id);

    void insert(Customer customer);

    void update(Customer customer);

    void deleteById(int id);
}
