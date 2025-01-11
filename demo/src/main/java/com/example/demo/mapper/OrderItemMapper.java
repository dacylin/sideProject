package com.example.demo.mapper;

import com.example.demo.entity.OrderItem;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface OrderItemMapper {
    void insert(OrderItem orderItem);

    List<OrderItem> findByOrderId(int orderId);
}
