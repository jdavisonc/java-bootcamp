package com.example.sk.javabootcamp.skjavabootcamp.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id) {
        super("Can't find the User with id: " + id.toString());
    }
    public UserNotFoundException(String username){
        super("Can't find the user with username : " + username);
    }
}
