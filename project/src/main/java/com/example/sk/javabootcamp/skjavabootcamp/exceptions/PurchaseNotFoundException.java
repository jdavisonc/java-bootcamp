package com.example.sk.javabootcamp.skjavabootcamp.exceptions;


public class PurchaseNotFoundException extends RuntimeException {

    public PurchaseNotFoundException(Long id){
        super (id.toString());
    }
}
