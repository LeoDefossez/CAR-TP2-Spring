package com.example.app.repository;

import com.example.app.entity.Product;
import org.springframework.data.repository.CrudRepository;


public interface ProductRepository extends CrudRepository<Product,String> {


}