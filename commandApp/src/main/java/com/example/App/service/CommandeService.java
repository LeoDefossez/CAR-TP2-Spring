package com.example.App.service;

import com.example.App.entity.Client;
import com.example.App.entity.Commande;
import com.example.App.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    public CommandeService(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }

    public void createCommande(Client client, String name) {
        Commande commande = new Commande(name, client);
        commandeRepository.save(commande);
    }

    public Commande getCommandeById(long id) {
        return commandeRepository.findById(id).orElse(null);
    }


}
