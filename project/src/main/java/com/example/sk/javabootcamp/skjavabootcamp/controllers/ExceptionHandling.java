package com.example.sk.javabootcamp.skjavabootcamp.controllers;

import com.example.sk.javabootcamp.skjavabootcamp.exceptions.CartNotFoundException;
import com.example.sk.javabootcamp.skjavabootcamp.exceptions.CategoryNotFoundException;
import com.example.sk.javabootcamp.skjavabootcamp.exceptions.ProductNotFoundException;
import com.example.sk.javabootcamp.skjavabootcamp.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ExceptionHandling {

    @ResponseBody
    @ExceptionHandler(CategoryNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String categoryNotFoundHandler(CategoryNotFoundException ex){
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String productNotFoundHandler(ProductNotFoundException ex){
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(CartNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String cartNotFoundExceptionHandler(CartNotFoundException ex){
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String userNotFoundExceptionHandler(UserNotFoundException ex){
        return ex.getMessage();
    }




}
