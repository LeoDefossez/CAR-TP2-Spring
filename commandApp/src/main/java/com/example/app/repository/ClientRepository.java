package com.example.app.repository;

import com.example.app.entity.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client,String> {
}
