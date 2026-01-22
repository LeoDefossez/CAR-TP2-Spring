package com.example.app;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {

    private final StockProducer kafkaProducer;

    public StockController(StockProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/messages")
    public void produceMessage(@RequestBody String message) {
        kafkaProducer.produce(message);
    }
}
