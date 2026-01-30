package com.example.app.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import com.example.app.entity.CommandeLigne;

@Data
@NoArgsConstructor
public class CommandeEvent {
    private String libelle;
    private long quantity;

    public CommandeEvent(String libelle,  long quantity){
        this.libelle = libelle;
        this.quantity = quantity;
    }
    public static CommandeEvent fromCommandeLine(CommandeLigne line){
        return new CommandeEvent(line.getLibelle(), line.getQuantity());
    }
}