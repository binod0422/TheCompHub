package com.example.TheCompHub.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.TheCompHub.entities.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

}
