package com.example.app.consumer;

import com.example.app.dto.CommandeEvent;
import com.example.app.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Component
public class StockConsumer {
    private ObjectMapper objectMapper;

    @Autowired
    private ProductService productService;

    private final static Logger LOGGER = LoggerFactory.getLogger(StockConsumer.class);

    public StockConsumer() {
        this.objectMapper = new ObjectMapper();
    }

    @KafkaListener(topics = "my-first-topic", groupId = "group_id")
    public void consume(String message) {
        LOGGER.info("Ordre de réduction reçu : {}", message);

        try {
            CommandeEvent event = objectMapper.readValue(message, CommandeEvent.class);

            productService.reduceProductQuantity(event.getLibelle(), (int) event.getQuantity());

            LOGGER.info("Succès : Stock réduit de {} pour {}", event.getQuantity() ,event.getLibelle());

        } catch (RuntimeException e) {
            LOGGER.error("Stock insuffisant ou produit introuvable : {}", e.getMessage());
        }
    }


}

