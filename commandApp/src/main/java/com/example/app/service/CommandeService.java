package com.example.app.service;

import com.example.app.entity.Client;
import com.example.app.entity.Commande;
import com.example.app.repository.CommandeRepository;
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
