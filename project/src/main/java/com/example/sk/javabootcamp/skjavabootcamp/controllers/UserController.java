package com.example.sk.javabootcamp.skjavabootcamp.controllers;

import com.example.sk.javabootcamp.skjavabootcamp.exceptions.UserNotFoundException;
import com.example.sk.javabootcamp.skjavabootcamp.models.Product;
import com.example.sk.javabootcamp.skjavabootcamp.models.User;
import com.example.sk.javabootcamp.skjavabootcamp.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class UserController {

    private final UserRepository userRepository;

    UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    List<User> all() {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    User newUser(@RequestBody User newUser) {
        return userRepository.save(newUser);
    }

    @GetMapping("/users/{username}")
    User findByUsername(@PathVariable("username") String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(username));

    }
    @GetMapping("/users/email/{email}")
    User findByEmail(@PathVariable("email") String email){
        return userRepository.findByEmail(email)
                .orElseThrow(() ->  new UserNotFoundException(email));
    }


    @PutMapping("/users/{username}")
    User replaceUser(@RequestBody User newUser, @PathVariable("username") String username) {
        return userRepository.findByUsername(username)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setEmail(newUser.getEmail());
                    user.setPassword(newUser.getPassword());
                    return userRepository.save(user);
                })
                .orElseGet(() -> userRepository.save(newUser));
    }

    @DeleteMapping("/users/{username}")
    void deleteUser(@PathVariable("username") String username) {
        userRepository.deleteByUsername(username);
    }

    @GetMapping("/users/{username}/recommendations")
    Set<Product> getRecommendations(@PathVariable("username") String username) {
        return findByUsername(username).getRecommendedProducts();
    }

}
