package com.example.sk.javabootcamp.skjavabootcamp.controllers;

import com.example.sk.javabootcamp.skjavabootcamp.exceptions.UserNotFoundException;
import com.example.sk.javabootcamp.skjavabootcamp.models.Cart;
import com.example.sk.javabootcamp.skjavabootcamp.models.Product;
import com.example.sk.javabootcamp.skjavabootcamp.models.ShopUser;
import com.example.sk.javabootcamp.skjavabootcamp.repositories.CartRepository;
import com.example.sk.javabootcamp.skjavabootcamp.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class UserController {

    private final UserRepository userRepository;
    private final CartRepository cartRepository;

    UserController(UserRepository userRepository, CartRepository cartRepository) {
        this.userRepository = userRepository;
        this.cartRepository = cartRepository;
    }

    @GetMapping("/users")
    List<ShopUser> all() {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    ShopUser newUser(@RequestBody ShopUser newShopUser) {

        Cart cart = newShopUser.getCart();
        if (cart == null){
            cart = new Cart();
        }
        cart.setUser(newShopUser);
        cartRepository.save(cart);
        return userRepository.save(newShopUser);
    }

    @GetMapping("/users/{username}")
    ShopUser findByUsername(@PathVariable("username") String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(username));

    }
    @GetMapping("/users/email/{email}")
    ShopUser findByEmail(@PathVariable("email") String email){
        return userRepository.findByEmail(email)
                .orElseThrow(() ->  new UserNotFoundException(email));
    }


    @PutMapping("/users/{username}")
    ShopUser replaceUser(@RequestBody ShopUser newShopUser, @PathVariable("username") String username) {
        return userRepository.findByUsername(username)
                .map(shopUser -> {
                    shopUser.setUsername(newShopUser.getUsername());
                    shopUser.setEmail(newShopUser.getEmail());
                    shopUser.setPassword(newShopUser.getPassword());
                    return userRepository.save(shopUser);
                })
                .orElseGet(() -> userRepository.save(newShopUser));
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
