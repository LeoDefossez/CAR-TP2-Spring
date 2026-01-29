package com.example.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {


    @Id
    @GeneratedValue
    private int id;

    private String libelle;

    private int quantity;

    private float cost;


    public Product(String libelle, int quantity, float cost) {
        this.libelle = libelle;
        this.quantity = quantity;
        this.cost = cost;
    }



}
