package com.example.demo.service.impl;

import com.example.demo.entity.Customer;
import com.example.demo.mapper.CustomerMapper;
import com.example.demo.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerMapper.findAll();
    }

    @Override
    public Customer getCustomerById(int id) {
        return customerMapper.findById(id);
    }

    @Override
    public void addCustomer(Customer customer) {
        customerMapper.insert(customer);
    }

    @Override
    public void deleteCustomerById(int id) {
        customerMapper.deleteById(id);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerMapper.update(customer);
    }
}
