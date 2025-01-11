package com.example.demo.service;

import com.example.demo.entity.Order;

import java.util.List;
import java.util.Map;

public interface OrderService {
    void createOrder(Order order);

    List<Order> getOrdersByCustomerId(int customerId);

    List<Order> getOrdersByDateRange(String startDate, String endDate);

    int getCustomerTotalAmount(int customerId);

    List<Map<String, Object>> getTopSellingProducts(int topN);

    List<Map<String, Object>> getTopSpendingCustomers(int topN);
}
