package com.example.demo.entity;

import lombok.Data;

@Data
public class OrderItem {
    private int id;
    private int orderId;
    private int productId;
    private int quantity;
    private int price;
}
