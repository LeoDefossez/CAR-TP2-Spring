package com.example.app.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class StockProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public StockProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void produce(String message) {
        kafkaTemplate.send("my-first-topic", message);
    }
}
