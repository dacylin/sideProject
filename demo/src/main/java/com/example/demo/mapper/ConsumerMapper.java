package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.Consumer;

@Mapper
public interface ConsumerMapper {

    List<Consumer> getAllConsumers();

    Consumer getConsumerById(@Param("id") Integer id);

    void insertConsumer(Consumer consumer);

    void updateConsumer(Consumer consumer);

    void deleteConsumer(@Param("id") Integer id);

}
