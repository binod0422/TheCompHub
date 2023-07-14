package com.example.TheCompHub.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.TheCompHub.entities.BestSellers;

@Repository
public interface BestSellersRepository extends CrudRepository<BestSellers, Integer> {

}
