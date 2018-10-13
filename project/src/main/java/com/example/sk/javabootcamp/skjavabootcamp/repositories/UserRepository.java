package com.example.sk.javabootcamp.skjavabootcamp.repositories;

import com.example.sk.javabootcamp.skjavabootcamp.models.ShopUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<ShopUser, Long> {

    Optional<ShopUser> findByUsername(String username);
    Optional<ShopUser> findByEmail(String email);
    void deleteByUsername(String username);
}
