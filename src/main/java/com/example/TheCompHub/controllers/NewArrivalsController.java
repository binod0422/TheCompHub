package com.example.TheCompHub.controllers;

import com.example.TheCompHub.entities.NewArrivals;
import com.example.TheCompHub.services.NewArrivalsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;

@RestController
@RequestMapping("/newarrivals")
public class NewArrivalsController {

    private final NewArrivalsService newArrivalsService;

    public NewArrivalsController(NewArrivalsService newArrivalsService) {
        this.newArrivalsService = newArrivalsService;
    }

    @GetMapping
    public ResponseEntity<Iterable<NewArrivals>> findAllNewArrivals(){
        return ResponseEntity.ok(newArrivalsService.findAllNewArrivals());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewArrivals> getNewArrivalsById(@PathVariable Integer id){
        return ResponseEntity.ok(newArrivalsService.getAccessoryById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<NewArrivals> addNewArrivals(@RequestBody NewArrivals newArrivals){
        NewArrivals savedNewArrivals = newArrivalsService.addNewArrivals(newArrivals);

        URI location = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/newarrivals/{id}")
                .buildAndExpand(savedNewArrivals.getId())
                .toUri();

        return ResponseEntity.created(location).body(newArrivals);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NewArrivals>  updatedNewArrivals(@PathVariable Integer id, @RequestBody NewArrivals updates){
        return ResponseEntity.ok(newArrivalsService.updateNewArrivals(id, updates));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HashMap<String, Object>> deleteNewArrivals(@PathVariable Integer id){

        HashMap<String, Object> responseMap = newArrivalsService.deleteNewArrivals(id);

        if(responseMap.get("playerInfo") == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMap);
        }

        return ResponseEntity.ok(responseMap);
    }





}