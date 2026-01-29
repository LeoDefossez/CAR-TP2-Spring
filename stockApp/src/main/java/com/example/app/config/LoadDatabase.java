package com.example.app.config;

import com.example.app.entity.Product;
import com.example.app.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ProductRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                log.info("Initialisation de la base de données...");

                repository.save(new Product("Samsung S23", 10, 950.00f));
                repository.save(new Product("Iphone 15", 5, 1200.50f));
                repository.save(new Product("Casque Sony", 20, 250.00f));

                log.info("Produits initiaux insérés avec succès !");
            } else {
                log.info("La base de données contient déjà des produits. Pas d'initialisation requise.");
            }
        };
    }
}