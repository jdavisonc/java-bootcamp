package com.example.sk.javabootcamp.skjavabootcamp.exceptions;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(Long id) {
        super("Can't find the Category with id: " +id.toString());
    }

    public CategoryNotFoundException(String name) {
        super("Can't find the Category with name: " + name);
    }

}
