package com.example.App.service;

import com.example.App.entity.Client;
import com.example.App.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void registerClient(String email, String password, String name, String firstname) {
        Client client = new Client(email, password, name, firstname);
        clientRepository.save(client);
    }

    public Iterable<Client> readAllClients() {
        return clientRepository.findAll();
    }

    public Client clientWithEmailAndPassword(String email, String password) {
        Optional<Client> maybeClient = clientRepository.findById(email);
        if (maybeClient.isEmpty()) {
            return null;
        }
        Client client = maybeClient.get();

        if (!Objects.equals(client.getPassword(), password)) {
            return null;
        }

        return client;
    }

    public Client getClientByEmail(String email) {
        return clientRepository.findById(email).orElse(null);
    }
}
