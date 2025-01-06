package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Consumer;
import com.example.demo.service.ConsumerService;

@SpringBootTest
public class ConsumerServiceTest {

    @Autowired
    private ConsumerService consumerService;

    @Test
    public void testGetAllConsumers() {
        List<Consumer> consumers = consumerService.getAllConsumers();
        consumers.forEach(System.out::println);
    }

    @Test
    public void testAddConsumer() {
        Consumer consumer = new Consumer();
        consumer.setConsumersName("John Doe");
        consumer.setConsumersEmail("john.doe@example.com");
        consumer.setConsumersPhone("123456789");
        consumer.setConsumersAddress("123 Main St");
        consumerService.addConsumer(consumer);
        System.out.println("新增成功，ID：" + consumer.getConsumersId());
    }

    @Test
    public void testUpdateConsumer() {
        Consumer consumer = new Consumer();
        consumer.setConsumersId(1); // 指定更新的 ID
        consumer.setConsumersName("Jane Doe");
        consumer.setConsumersEmail("jane.doe@example.com");
        consumer.setConsumersPhone("987654321");
        consumer.setConsumersAddress("456 Elm St");
        consumerService.updateConsumer(consumer);
        System.out.println("更新成功");
    }

    @Test
    public void testDeleteConsumer() {
        consumerService.deleteConsumer(1); // 刪除指定 ID
        System.out.println("刪除成功");
    }

}
