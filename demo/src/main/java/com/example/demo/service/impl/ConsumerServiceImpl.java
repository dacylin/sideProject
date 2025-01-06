package com.example.demo.service.impl;

import com.example.demo.entity.Consumer;
import com.example.demo.mapper.ConsumerMapper;
import com.example.demo.service.ConsumerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumerServiceImpl implements ConsumerService {

    private final ConsumerMapper consumerMapper;

    public ConsumerServiceImpl(ConsumerMapper consumerMapper) {
        this.consumerMapper = consumerMapper;
    }

    @Override
    public List<Consumer> getAllConsumers() {
        return consumerMapper.getAllConsumers();
    }

    @Override
    public Consumer getConsumerById(Integer id) {
        return consumerMapper.getConsumerById(id);
    }

    @Override
    public void addConsumer(Consumer consumer) {
        consumerMapper.insertConsumer(consumer);
    }

    @Override
    public void updateConsumer(Consumer consumer) {
        consumerMapper.updateConsumer(consumer);
    }

    @Override
    public void deleteConsumer(Integer id) {
        consumerMapper.deleteConsumer(id);
    }
}
