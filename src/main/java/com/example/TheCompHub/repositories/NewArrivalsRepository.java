package com.example.TheCompHub.repositories;

import com.example.TheCompHub.entities.NewArrivals;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

@Repository

public interface NewArrivalsRepository extends CrudRepository<NewArrivals, Integer> {
}
