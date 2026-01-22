package com.example.App.repository;

import com.example.App.entity.Client;
import com.example.App.entity.Commande;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface CommandeRepository extends CrudRepository<Commande,Long> {

    List<Commande> findByClient(Client client);

}
