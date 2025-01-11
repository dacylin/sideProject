package com.example.demo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.Order;

@Mapper
public interface OrderMapper {
    void insert(Order order);

    List<Order> findByCustomerId(int customerId);

    List<Order> findByDateRange(String startDate, String endDate);

    int getCustomerTotalAmount(int customerId);

    List<Map<String, Object>> findTopSellingProducts(@Param("topN") int topN);

    List<Map<String, Object>> findTopSpendingCustomers(@Param("topN") int topN);
}
