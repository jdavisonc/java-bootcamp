package com.example.sk.javabootcamp.skjavabootcamp.exceptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Long id) {
        super(id.toString());
    }

    public ProductNotFoundException(String name){super(name);}
}
