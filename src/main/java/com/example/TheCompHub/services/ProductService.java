package com.example.TheCompHub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.TheCompHub.repositories.ProductRepository;
import com.example.TheCompHub.entities.Product;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public long countProducts(){
        return productRepository.count();
    }
    public Iterable<Product> getProducts(){
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Integer id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct;
    }

    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> addProducts(List<Product> product){
        return (List<Product>) productRepository.saveAll(product);
    }




}
