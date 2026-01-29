package com.example.app.repository;

import com.example.app.entity.Commande;
import com.example.app.entity.CommandeLigne;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommandeLigneRepository  extends CrudRepository<CommandeLigne,Long> {

    List<CommandeLigne> findByCommande(Commande commande);
}
