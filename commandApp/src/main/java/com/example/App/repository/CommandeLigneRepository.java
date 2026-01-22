package com.example.App.repository;

import com.example.App.entity.Commande;
import com.example.App.entity.CommandeLigne;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommandeLigneRepository  extends CrudRepository<CommandeLigne,Long> {

    List<CommandeLigne> findByCommande(Commande commande);
}
