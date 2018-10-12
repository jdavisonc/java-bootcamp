package com.example.sk.javabootcamp.skjavabootcamp.controllers;

import com.example.sk.javabootcamp.skjavabootcamp.models.Category;
import com.example.sk.javabootcamp.skjavabootcamp.models.Product;
import com.example.sk.javabootcamp.skjavabootcamp.models.Purchase;
import com.example.sk.javabootcamp.skjavabootcamp.models.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private UserController userController;

    @Test
    public void allTest() throws Exception {
        User john = new User("John", "password", "john@gmail.com");
        User dave = new User("Dave", "password", "dave@gmail.com");

        List<User> users = new ArrayList<>();
        users.add(john);
        users.add(dave);

        when(userController.all()).thenReturn(users);

        mockMvc.perform(get("/users"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].username", is("John")))
                .andExpect(jsonPath("$[1].username", is("Dave")))
                .andExpect(jsonPath("$", hasSize(2)));

        verify(userController).all();
        verifyNoMoreInteractions(userController);
    }

    @Test
    public void newUserTest() throws Exception {
        User dave = new User("Dave", "password", "dave@gmail.com");

        when(userController.newUser(dave)).thenReturn(dave);

        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsString(dave)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username", is(dave.getUsername())));

        verify(userController).newUser(dave);
        verifyNoMoreInteractions(userController);
    }

    @Test
    public void findByUsernameTest() throws Exception {
        User dave = new User("Dave", "password", "dave@gmail.com");

        when(userController.findByUsername(dave.getUsername())).thenReturn(dave);

        mockMvc.perform(get("/users/{username}", dave.getUsername()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.username", is(dave.getUsername())));

        verify(userController).findByUsername(dave.getUsername());
        verifyNoMoreInteractions(userController);
    }

    @Test
    public void findByEmailTest() throws Exception {
        User dave = new User("Dave", "password", "dave@gmail.com");

        when(userController.findByEmail(dave.getEmail())).thenReturn(dave);

        mockMvc.perform(get("/users/email/{email}", dave.getEmail()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.username", is(dave.getUsername())));

        verify(userController).findByEmail(dave.getEmail());
        verifyNoMoreInteractions(userController);
    }

    @Test
    public void replaceUserTest() throws Exception {
        User dave = new User("Dave", "password", "dave@gmail.com");
        User john = new User("John", "password", "john@gmail.com");

        when(userController.replaceUser(john, dave.getUsername())).thenReturn(john);

        mockMvc.perform(put("/users/{username}", dave.getUsername())
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsString(john)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username", is(john.getUsername())));
        verify(userController).replaceUser(john, dave.getUsername());
        verifyNoMoreInteractions(userController);
    }

    @Test
    public void deleteUserTest() throws Exception {
        User john = new User("John", "password", "john@gmail.com");
        doNothing().when(userController).deleteUser(john.getUsername());

        mockMvc.perform(delete("/users/{username}", john.getUsername()))
                .andExpect(status().isOk());

        verify(userController).deleteUser(john.getUsername());
        verifyNoMoreInteractions(userController);
    }

    @Test
    public void getRecommendations() throws Exception {
        User john = new User("John", "password", "john@gmail.com");
        Purchase purchaseOne = new Purchase(getMockProducts());
        Purchase purchaseTwo = new Purchase(getMockProducts());
        Set<Purchase> purchases = new HashSet<>();
        purchases.add(purchaseOne);
        purchases.add(purchaseTwo);
        john.setPurchases(purchases);

        when(userController.getRecommendations(john.getUsername())).thenReturn(john.getRecommendedProducts());

        mockMvc.perform(get("/users/{username}/recommendations", john.getUsername()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$[0].name", is("Dark chocolate")));
        verify(userController).getRecommendations(john.getUsername());
        verifyNoMoreInteractions(userController);

    }

    public Set<Product> getMockProducts() {
        Category category = new Category("chocolate");
        Set<Product> products = new HashSet<>();
        Product dark = new Product("Dark chocolate", 150L, "", category);
        Product white = new Product("White chocolate", 180L, "", category);
        products.add(white);
        products.add(dark);
        return products;
    }
}