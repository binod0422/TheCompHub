package com.example.TheCompHub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.TheCompHub.repositories.ProductRepository;
import com.example.TheCompHub.entities.Product;

import java.util.HashMap;
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
        return productRepository.findById(id);
    }

    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> addProducts(List<Product> product){
        return (List<Product>) productRepository.saveAll(product);
    }

    public Product updateProduct(Integer id, Product updates) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isEmpty()) {
            throw new RuntimeException("Product not found with id: " + id);
        }

        Product productToUpdate = optionalProduct.get();
        productToUpdate.setName(updates.getName());
        productToUpdate.setDescription(updates.getDescription());
        productToUpdate.setPrice(updates.getPrice());
        productToUpdate.setCategory(updates.getCategory());

        return productRepository.save(productToUpdate);
    }

    
    
    public HashMap<String, Object> deleteProduct(Integer id) {
        HashMap<String, Object> responseMap = new HashMap<>();

        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isEmpty()) {
            responseMap.put("wasDeleted", false);
            responseMap.put("productInfo", null);
            responseMap.put("message", "Product not found with id: " + id);
            return responseMap;
        }

        Product product = optionalProduct.get();

        productRepository.delete(product);

        responseMap.put("wasDeleted", true);
        responseMap.put("productInfo", product);

        return responseMap;
    }


}
