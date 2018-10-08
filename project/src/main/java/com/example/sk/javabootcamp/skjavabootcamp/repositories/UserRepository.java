package com.example.sk.javabootcamp.skjavabootcamp.repositories;

import com.example.sk.javabootcamp.skjavabootcamp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
