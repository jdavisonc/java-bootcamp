package com.example.sk.javabootcamp.skjavabootcamp.exceptions;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(Long id) {
        super(id.toString());
    }
}
