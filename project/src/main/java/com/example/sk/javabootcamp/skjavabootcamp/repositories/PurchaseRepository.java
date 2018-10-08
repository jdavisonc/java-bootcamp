package com.example.sk.javabootcamp.skjavabootcamp.repositories;

import com.example.sk.javabootcamp.skjavabootcamp.models.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository <Purchase, Long> {
}
