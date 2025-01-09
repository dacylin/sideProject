package com.example.demo.service;

import com.example.demo.entity.Customer;
import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();

    Customer getCustomerById(int id);

    void addCustomer(Customer customer);

    void deleteCustomerById(int id);

    void updateCustomer(Customer customer);
}
