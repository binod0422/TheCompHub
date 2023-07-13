package com.example.TheCompHub.repositories;

import com.example.TheCompHub.entities.Accessory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessoryRepository extends CrudRepository<Accessory, Integer> {
}
