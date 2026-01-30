package com.example.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class CommandeLigne {

    @Id @GeneratedValue
    private long Id;

    private String libelle;

    private long quantity;


    @ManyToOne
    private Commande commande;

    public CommandeLigne() {
    }

    public CommandeLigne(String libelle, long quantity,  Commande commande) {
        this.libelle = libelle;
        this.quantity = quantity;
        this.commande = commande;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }


    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }
}
