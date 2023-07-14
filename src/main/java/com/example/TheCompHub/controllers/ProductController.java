package com.example.TheCompHub.controllers;

import com.example.TheCompHub.entities.Product;
import com.example.TheCompHub.entities.BestSellers;
import com.example.TheCompHub.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin
public class ProductController {
    @Autowired
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/api/products")
    public ResponseEntity<Iterable<Product>> getProduct(){
        if(productService.countProducts() <= 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(productService.getProducts());
    }

    @GetMapping("/api/products/{id}")
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable Integer id){
        Optional<Product> product = productService.getProductById(id);
        if(product.isEmpty()){
            ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(product));
    }

    @PostMapping("/api/products")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product addProduct = productService.addProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(addProduct);
    }


    @PostMapping("/api/products/all")
    public ResponseEntity<List<Product>> addProducts(@RequestBody List<Product> products) {
        List<Product> savedProducts = productService.addProducts(products);
        return ResponseEntity.ok(savedProducts);
    }




    @PutMapping("/api/products/{id}")
    public ResponseEntity<Product>  updatedPlayer(@PathVariable Integer id, @RequestBody Product updates){
        return ResponseEntity.ok(productService.updateProduct(id, updates));
    }

    @DeleteMapping("/api/products/{id}")
    public ResponseEntity<HashMap<String, Object>> deleteProduct(@PathVariable Integer id){

        HashMap<String, Object> responseMap = productService.deleteProduct(id);

        if(responseMap.get("productInfo") == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMap);
        }

        return ResponseEntity.ok(responseMap);
    }


    @GetMapping("/api/bestSellers")
    public ResponseEntity<Iterable<BestSellers>> getBestSellers() {
        if (productService.countBestSellers() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(productService.getBestSellers());
    }

    @GetMapping("/api/bestSellers/{id}")
    public ResponseEntity<Optional<BestSellers>> getBestSellerById(@PathVariable Integer id) {
        Optional<BestSellers> bestSeller = productService.getBestSellerById(id);
        if (bestSeller.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(bestSeller));
    }

    @PostMapping("/api/bestSellers")
    public ResponseEntity<BestSellers> addBestSeller(@RequestBody BestSellers bestSeller) {
        BestSellers addedBestSeller = productService.addBestSeller(bestSeller);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedBestSeller);
    }

    @PostMapping("/api/bestSellers/all")
    public ResponseEntity<List<BestSellers>> addBestSellers(@RequestBody List<BestSellers> bestSellers) {
        List<BestSellers> savedBestSellers = productService.addBestSellers(bestSellers);
        return ResponseEntity.ok(savedBestSellers);
    }

    @PutMapping("/api/bestSellers/{id}")
    public ResponseEntity<BestSellers> updateBestSeller(@PathVariable Integer id, @RequestBody BestSellers updates) {
        return ResponseEntity.ok(productService.updateBestSeller(id, updates));
    }

    @DeleteMapping("/api/bestSellers/{id}")
    public ResponseEntity<HashMap<String, Object>> deleteBestSeller(@PathVariable Integer id) {
        HashMap<String, Object> responseMap = productService.deleteBestSeller(id);

        if (responseMap.get("bestSellerInfo") == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMap);
        }

        return ResponseEntity.ok(responseMap);
    }



}
