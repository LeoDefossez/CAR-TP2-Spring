package com.example.app.service;

import com.example.app.entity.Commande;
import com.example.app.entity.CommandeLigne;
import com.example.app.repository.CommandeLigneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandeLigneService {

    @Autowired
    private CommandeLigneRepository commandeLigneRepository;


    public CommandeLigneService(CommandeLigneRepository commandeLigneRepository) {
        this.commandeLigneRepository = commandeLigneRepository;
    }

    public void createCommandeLine(String libelle, long quantity, Commande commande){
        CommandeLigne line = new CommandeLigne(libelle,quantity,commande);
        commandeLigneRepository.save(line);
    }

    public CommandeLigne getLineById(long id){
        return commandeLigneRepository.findById(id).orElse(null);
    }

    public void deleteLineById(long id) {
        commandeLigneRepository.deleteById(id);
    }
}
