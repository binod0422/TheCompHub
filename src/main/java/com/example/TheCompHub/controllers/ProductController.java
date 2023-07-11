package com.example.TheCompHub.controllers;

import com.example.TheCompHub.entities.Product;
import com.example.TheCompHub.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductController {
    @Autowired
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Product>> getProduct(){
        if(productService.countProducts() <= 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(productService.getProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable Integer id){
        Optional<Product> product = productService.getProductById(id);
        if(product.isEmpty()){
            ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(product));
    }

    @PostMapping
    public ResponseEntity<Product> addUser(@RequestBody Product product) {
        Product addProduct = productService.addProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(addProduct);
    }



}
