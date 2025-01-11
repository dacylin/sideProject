package com.example.demo.controller;

import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public void createOrder(@RequestBody Order order) {
        orderService.createOrder(order);
    }

    @GetMapping("/customer/{customerId}")
    public List<Order> getOrdersByCustomer(@PathVariable int customerId) {
        return orderService.getOrdersByCustomerId(customerId);
    }

    @GetMapping("/date-range")
    public List<Order> getOrdersByDateRange(@RequestParam String startDate, @RequestParam String endDate) {
        return orderService.getOrdersByDateRange(startDate, endDate);
    }

    @GetMapping("/customer/{customerId}/total-amount")
    public int getCustomerTotalAmount(@PathVariable int customerId) {
        return orderService.getCustomerTotalAmount(customerId);
    }

    @GetMapping("/top-products")
    public List<Map<String, Object>> getTopSellingProducts(
            @RequestParam(defaultValue = "3") int topN) {
        return orderService.getTopSellingProducts(topN);
    }

    @GetMapping("/top-customers")
    public List<Map<String, Object>> getTopSpendingCustomers(
            @RequestParam(defaultValue = "2") int topN) {
        return orderService.getTopSpendingCustomers(topN);
    }
}
