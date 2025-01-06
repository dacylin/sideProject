package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Consumer;

public interface ConsumerService {

    List<Consumer> getAllConsumers();

    Consumer getConsumerById(Integer id);

    void addConsumer(Consumer consumer);

    void updateConsumer(Consumer consumer);

    void deleteConsumer(Integer id);

}
