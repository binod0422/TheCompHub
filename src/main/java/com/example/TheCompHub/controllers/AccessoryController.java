package com.example.TheCompHub.controllers;

import com.example.TheCompHub.entities.Accessory;
import com.example.TheCompHub.services.AccessoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;

@RestController
@RequestMapping("/api/accessory")
@CrossOrigin
public class AccessoryController {

    @Autowired
    private final AccessoryService accessoryService;

    public AccessoryController(AccessoryService accessoryService) {
        this.accessoryService = accessoryService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Accessory>> getAccessory(){
        return ResponseEntity.ok(accessoryService.getAccessory());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Accessory> getAccessoryById(@PathVariable Integer id){
        return ResponseEntity.ok(accessoryService.getAccessoryById(id));
    }

    @PostMapping
    public ResponseEntity<Accessory> addAccessory(@RequestBody Accessory accessory){
        Accessory addAccessory = accessoryService.addAccessory(accessory);
//        Accessory savedAccessory = accessoryService.addAccessory(accessory);

//        URI location = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/accessory/{id}")
//                .buildAndExpand(savedAccessory.getId())
//                .toUri();

        return ResponseEntity.status(HttpStatus.CREATED).body(addAccessory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Accessory>  updatedPlayer(@PathVariable Integer id, @RequestBody Accessory updates){
        return ResponseEntity.ok(accessoryService.updateAccessory(id, updates));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HashMap<String, Object>> deleteAccessory(@PathVariable Integer id) {
        HashMap<String, Object> responseMap = accessoryService.deleteAccessory(id);

        if (responseMap.get("accessoryInfo") == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMap);
        }

        return ResponseEntity.ok(responseMap);
    }






}
