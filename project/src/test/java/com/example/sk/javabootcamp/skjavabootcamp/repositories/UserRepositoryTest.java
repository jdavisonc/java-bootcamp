package com.example.sk.javabootcamp.skjavabootcamp.repositories;

import com.example.sk.javabootcamp.skjavabootcamp.exceptions.UserNotFoundException;
import com.example.sk.javabootcamp.skjavabootcamp.models.Cart;
import com.example.sk.javabootcamp.skjavabootcamp.models.ShopUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void findByUsername() {
        ShopUser user = new ShopUser("santiago", "santiago" , "santiago@gmail.com");
        assertEquals(user, userRepository
                .findByUsername(user.getUsername())
                .orElseThrow(() -> new UserNotFoundException(user.getUsername())));
        assertNotNull(userRepository.findByUsername("santiago"));
    }

    @Test
    public void findByEmail() {
    }

    @Test
    public void deleteByUsername() {
    }
}