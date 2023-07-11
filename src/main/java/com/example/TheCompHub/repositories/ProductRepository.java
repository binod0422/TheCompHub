package com.example.TheCompHub.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductEntity extends CrudRepository<Product, Integer> {
}
