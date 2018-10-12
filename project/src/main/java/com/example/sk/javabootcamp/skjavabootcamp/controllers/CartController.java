package com.example.sk.javabootcamp.skjavabootcamp.controllers;

import com.example.sk.javabootcamp.skjavabootcamp.exceptions.CartNotFoundException;
import com.example.sk.javabootcamp.skjavabootcamp.models.Cart;
import com.example.sk.javabootcamp.skjavabootcamp.models.Product;
import com.example.sk.javabootcamp.skjavabootcamp.repositories.CartRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {

    private final CartRepository cartRepository;

    CartController(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @GetMapping("/carts")
    List<Cart> all() {
        return cartRepository.findAll();
    }


    @GetMapping("/carts/{id}")
    Cart one(@PathVariable("id") Long id) {
        return cartRepository.findById(id)
                .orElseThrow(() -> new CartNotFoundException(id));

    }

    @DeleteMapping("/carts/{id}")
    Cart emptyCart(@PathVariable("id") Long id) {
        Cart cart = one(id);
        cart.empty();
        return cartRepository.save(cart);
    }

    @PostMapping("/carts/{id}")
    Cart addProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        Cart cart = one(id);
        cart.addProduct(product);
        return cartRepository.save(cart);
    }

}
