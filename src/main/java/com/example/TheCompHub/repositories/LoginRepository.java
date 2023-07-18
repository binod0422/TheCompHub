package com.example.TheCompHub.repositories;

import org.springframework.data.repository.CrudRepository;
import com.example.TheCompHub.entities.Login;
import org.springframework.stereotype.Repository;

@Repository
public interface  LoginRepository extends CrudRepository<Login, Integer> {
}
