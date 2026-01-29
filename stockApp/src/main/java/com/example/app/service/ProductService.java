package com.example.app.service;

import com.example.app.entity.Product;
import com.example.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
