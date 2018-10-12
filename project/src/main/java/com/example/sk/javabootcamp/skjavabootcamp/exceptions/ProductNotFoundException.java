package com.example.sk.javabootcamp.skjavabootcamp.exceptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Long id) {
        super("Can't find the Product with id: " + id.toString());
    }

    public ProductNotFoundException(String name) {
        super("Can't find the Product with name: " + name);
    }
}
