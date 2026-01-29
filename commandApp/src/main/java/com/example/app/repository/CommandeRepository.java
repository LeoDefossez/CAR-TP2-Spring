package com.example.app.repository;

import com.example.app.entity.Client;
import com.example.app.entity.Commande;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface CommandeRepository extends CrudRepository<Commande,Long> {

    List<Commande> findByClient(Client client);

}
