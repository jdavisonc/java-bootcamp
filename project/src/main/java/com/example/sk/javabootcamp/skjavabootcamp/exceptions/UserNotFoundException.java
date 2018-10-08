package com.example.sk.javabootcamp.skjavabootcamp.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id){
        super(id.toString());
    }
}
