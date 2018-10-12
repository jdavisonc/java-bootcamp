package com.example.sk.javabootcamp.skjavabootcamp.repositories;

import com.example.sk.javabootcamp.skjavabootcamp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    void deleteByUsername(String username);
}
