package com.example.TheCompHub.services;

import com.example.TheCompHub.entities.NewArrivals;
import com.example.TheCompHub.repositories.NewArrivalsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Optional;

@Service
public class NewArrivalsService {
    private final NewArrivalsRepository newArrivalsRepository;

    public NewArrivalsService(NewArrivalsRepository newArrivalsRepository) {
        this.newArrivalsRepository = newArrivalsRepository;
    }

    public Iterable<NewArrivals> findAllNewArrivals() {
        return newArrivalsRepository.findAll();
    }

    public NewArrivals getNewArrivalsById(Integer id) {
        Optional<NewArrivals> optionalNewArrivals = newArrivalsRepository.findById(id);

        if (optionalNewArrivals.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Accessory not found with id: " + id);
        }

        return optionalNewArrivals.get();
    }


    public NewArrivals addNewArrivals(NewArrivals newArrivals) {
        return newArrivalsRepository.save(newArrivals);
    }

    public NewArrivals updateNewArrivals(Integer id, NewArrivals updates) {
        NewArrivals newArrivalsToUpdate = getNewArrivalsById(id);

        if (!updates.getName().isEmpty()) {
            newArrivalsToUpdate.setName(updates.getName());
        }
        if (updates.getImage() != null) {
            newArrivalsToUpdate.setImage(updates.getImage());
        }
        if (updates.getPrice() != null) {
            newArrivalsToUpdate.setPrice(updates.getPrice());
        }
        if (updates.getDescription() != null) {
            newArrivalsToUpdate.setDescription(updates.getDescription());
        }
        return newArrivalsRepository.save(newArrivalsToUpdate);
    }


    public HashMap<String, Object> deleteNewArrivals(Integer id) {
        HashMap<String, Object> responseMap = new HashMap<>();

        Optional<NewArrivals> optionalNewArrivals = newArrivalsRepository.findById(id);

        if (optionalNewArrivals.isEmpty()) {
//            if the player does not exist, this is what will be returned
            responseMap.put("wasDeleted", false);
            responseMap.put("accessoryInfo", null);
            responseMap.put("Message", "New Arrival item not found with id: " + id);
            return responseMap;
        }

        responseMap.put("wasDeleted", true);
        responseMap.put("newArrivalsInfo", optionalNewArrivals.get());

        return responseMap;
    }
}
