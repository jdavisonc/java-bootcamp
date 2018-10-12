package com.example.sk.javabootcamp.skjavabootcamp.controllers;

import com.example.sk.javabootcamp.skjavabootcamp.exceptions.ProductNotFoundException;
import com.example.sk.javabootcamp.skjavabootcamp.models.Product;
import com.example.sk.javabootcamp.skjavabootcamp.repositories.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductRepository productRepository;

    ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    List<Product> all() {
        return productRepository.findAll();
    }

    @PostMapping("/products")
    Product newProduct(@RequestBody Product newProduct) {
        return productRepository.save(newProduct);
    }

    @GetMapping("/products/{name}")
    Product one(@PathVariable("name") String name) {
        return productRepository.findProductByName(name)
                .orElseThrow(() -> new ProductNotFoundException(name));

    }

    @PutMapping("/products/{name}")
    Product replaceProduct(@RequestBody Product newProduct, @PathVariable("name") String name) {
        return productRepository.findProductByName(name)
                .map(product -> {
                    product.setName(newProduct.getName());
                    product.setCategory(newProduct.getCategory());
                    product.setDescription(newProduct.getDescription());
                    product.setPrice(newProduct.getPrice());
                    return productRepository.save(product);
                })
                .orElseGet(() -> productRepository.save(newProduct));
    }

    @DeleteMapping("/products/{name}")
    void deleteProduct(@PathVariable("name") String name) {
        productRepository.deleteProductByName(name);
    }

}
