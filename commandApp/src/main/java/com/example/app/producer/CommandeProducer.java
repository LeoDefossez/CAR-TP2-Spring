package com.example.app.producer;

import com.example.app.dto.CommandeEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

@Service
public class CommandeProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public CommandeProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void produce(String message) {
        kafkaTemplate.send("my-first-topic", message);
    }

    public void sendCommande(CommandeEvent event) {
        // Mapping object
        Map<String, Object> commandeMap = new HashMap<>();
        commandeMap.put("libelle", event.getLibelle());
        commandeMap.put("quantity", event.getQuantity());

        // Converting objet to String
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonMessage = objectMapper.writeValueAsString(commandeMap);

        // Send order
        kafkaTemplate.send("my-first-topic", jsonMessage);

    }

}


