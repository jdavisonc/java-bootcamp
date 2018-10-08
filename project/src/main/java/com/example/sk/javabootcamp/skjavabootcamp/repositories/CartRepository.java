package com.example.sk.javabootcamp.skjavabootcamp.repositories;

import com.example.sk.javabootcamp.skjavabootcamp.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
