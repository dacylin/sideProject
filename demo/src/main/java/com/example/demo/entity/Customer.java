package com.example.demo.entity;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Customer {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String password;
    private LocalDateTime createdAt;
}
