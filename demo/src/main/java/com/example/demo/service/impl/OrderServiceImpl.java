package com.example.demo.service.impl;

import com.example.demo.entity.Order;
import com.example.demo.entity.OrderItem;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.mapper.OrderItemMapper;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Override
    @Transactional
    public void createOrder(Order order) {

        int totalAmount = 0;
        for (OrderItem item : order.getOrderItems()) {
            totalAmount += item.getPrice() * item.getQuantity();
        }
        order.setTotalAmount(totalAmount);

        orderMapper.insert(order);

        for (OrderItem item : order.getOrderItems()) {
            item.setOrderId(order.getId());
            orderItemMapper.insert(item);
        }
    }

    @Override
    public List<Order> getOrdersByCustomerId(int customerId) {

        List<Order> orders = orderMapper.findByCustomerId(customerId);
        for (Order order : orders) {
            List<OrderItem> orderItems = orderItemMapper.findByOrderId(order.getId());
            order.setOrderItems(orderItems);
        }
        return orders;
    }

    @Override
    public List<Order> getOrdersByDateRange(String startDate, String endDate) {

        List<Order> orders = orderMapper.findByDateRange(startDate, endDate);
        for (Order order : orders) {
            List<OrderItem> orderItems = orderItemMapper.findByOrderId(order.getId());
            order.setOrderItems(orderItems);
        }
        return orders;
    }

    @Override
    public int getCustomerTotalAmount(int customerId) {
        return orderMapper.getCustomerTotalAmount(customerId);
    }

    @Override
    public List<Map<String, Object>> getTopSellingProducts(int topN) {
        return orderMapper.findTopSellingProducts(topN);
    }

    @Override
    public List<Map<String, Object>> getTopSpendingCustomers(int topN) {
        return orderMapper.findTopSpendingCustomers(topN);
    }
}
