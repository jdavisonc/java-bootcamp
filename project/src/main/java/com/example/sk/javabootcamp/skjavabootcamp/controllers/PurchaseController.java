package com.example.sk.javabootcamp.skjavabootcamp.controllers;

import com.example.sk.javabootcamp.skjavabootcamp.exceptions.PurchaseNotFoundException;
import com.example.sk.javabootcamp.skjavabootcamp.models.Cart;
import com.example.sk.javabootcamp.skjavabootcamp.models.Purchase;
import com.example.sk.javabootcamp.skjavabootcamp.repositories.CartRepository;
import com.example.sk.javabootcamp.skjavabootcamp.repositories.PurchaseRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PurchaseController {

    private final PurchaseRepository purchaseRepository;
    private final CartRepository cartRepository;

    PurchaseController(PurchaseRepository purchaseRepository, CartRepository cartRepository) {
        this.purchaseRepository = purchaseRepository;
        this.cartRepository = cartRepository;
    }

    @GetMapping("/purchases")
    List<Purchase> all() {
        return purchaseRepository.findAll();
    }

    @PostMapping("/purchases")
    Purchase newPurchase(@RequestBody Cart cart) {
        Purchase newPurchase = new Purchase(cart.getProducts());
        cart.empty();
        cartRepository.save(cart);
        return purchaseRepository.save(newPurchase);
    }

    @GetMapping("/purchases/{id}")
    Purchase one(@PathVariable Long id) {
        return purchaseRepository.findById(id)
                .orElseThrow(() -> new PurchaseNotFoundException(id));

    }
}
