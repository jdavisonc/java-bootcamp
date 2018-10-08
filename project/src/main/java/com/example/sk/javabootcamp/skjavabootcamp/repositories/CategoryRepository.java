package com.example.sk.javabootcamp.skjavabootcamp.repositories;

import com.example.sk.javabootcamp.skjavabootcamp.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
