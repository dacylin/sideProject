package com.example.demo.entity;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Order {
    private int id;
    private int customerId;
    private int totalAmount;
    private LocalDateTime createdAt;
    private List<OrderItem> orderItems;
}
