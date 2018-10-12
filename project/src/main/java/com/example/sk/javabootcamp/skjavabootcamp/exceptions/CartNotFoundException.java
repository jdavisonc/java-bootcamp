package com.example.sk.javabootcamp.skjavabootcamp.exceptions;

public class CartNotFoundException extends RuntimeException {

    public CartNotFoundException(Long id){
        super("Can't find the Cart with id: " +id.toString());
    }
}
