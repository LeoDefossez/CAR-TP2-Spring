package com.example.app.service;

import com.example.app.entity.Product;
import com.example.app.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Iterable<Product> allProducts() {
        return productRepository.findAll();
    }

    public void registerProduct(String libelle, int quantity, float cost) {
        Product product = new Product(libelle, quantity, cost);
        productRepository.save(product);
    }

    @Transactional
    public void reduceProductQuantity(String libelle, int quantity) {
        Product product = productRepository.findById(libelle)
                .orElseThrow(() -> new RuntimeException("Produit introuvable : " + libelle));


        if (product.getQuantity() < quantity) {
            throw new RuntimeException("Stock insuffisant pour " + libelle + ". Stock actuel : " + product.getQuantity());
        }

        product.setQuantity(product.getQuantity() - quantity);

        productRepository.save(product);
    }

    public Product productByLibelle(String libelle) {
        return productRepository.findById(libelle)
                .orElseThrow(() -> new RuntimeException("Produit introuvable : " + libelle));

    }

    @Transactional
    public void resupply() {
        Iterator<Product> products = productRepository.findAll().iterator();
        Product next;
        while (products.hasNext()){
            next = products.next();
            next.setQuantity(next.getQuantity() + 2);
            productRepository.save(next);
        }
    }
}
