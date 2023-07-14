package com.example.TheCompHub.services;

import com.example.TheCompHub.entities.Accessory;
import com.example.TheCompHub.repositories.AccessoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Optional;

@Service
public class AccessoryService {
    private final AccessoryRepository accessoryRepository;

    public AccessoryService(AccessoryRepository accessoryRepository) {
        this.accessoryRepository = accessoryRepository;
    }

    public Iterable<Accessory> getAccessory() {
        return accessoryRepository.findAll();
    }

    public Accessory getAccessoryById(Integer id) {
        Optional<Accessory> optionalAccessory = accessoryRepository.findById(id);

        if (optionalAccessory.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Accessory not found with id: " + id);
        }

        return optionalAccessory.get();
    }


    public Accessory addAccessory(Accessory accessory) {
        return accessoryRepository.save(accessory);
    }

    public Accessory updateAccessory(Integer id, Accessory updates) {
        Accessory accessoryToUpdate = getAccessoryById(id);

        if (!updates.getName().isEmpty()) {
            accessoryToUpdate.setName(updates.getName());
        }
        if (updates.getImage() != null) {
            accessoryToUpdate.setImage(updates.getImage());
        }
        if (updates.getPrice() != null) {
            accessoryToUpdate.setPrice(updates.getPrice());
        }
        if (updates.getDescription() != null) {
            accessoryToUpdate.setDescription(updates.getDescription());
        }
        return accessoryRepository.save(accessoryToUpdate);
    }


    public HashMap<String, Object> deleteAccessory(Integer id) {
        HashMap<String, Object> responseMap = new HashMap<>();

        Optional<Accessory> optionalAccessory = accessoryRepository.findById(id);

        if (optionalAccessory.isEmpty()) {
//            if the player does not exist, this is what will be returned
            responseMap.put("wasDeleted", false);
            responseMap.put("accessoryInfo", null);
            responseMap.put("Message", "Accessory not found with id: " + id);
            return responseMap;
        }

        responseMap.put("wasDeleted", true);
        responseMap.put("accessoryInfo", optionalAccessory.get());

        return responseMap;
    }


}



