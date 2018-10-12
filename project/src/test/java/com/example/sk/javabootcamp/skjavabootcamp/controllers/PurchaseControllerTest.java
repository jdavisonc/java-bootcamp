package com.example.sk.javabootcamp.skjavabootcamp.controllers;

import com.example.sk.javabootcamp.skjavabootcamp.models.Cart;
import com.example.sk.javabootcamp.skjavabootcamp.models.Category;
import com.example.sk.javabootcamp.skjavabootcamp.models.Product;
import com.example.sk.javabootcamp.skjavabootcamp.models.Purchase;
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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PurchaseControllerTest {

    ObjectMapper mapper = new ObjectMapper();


    @Autowired
    MockMvc mockMvc;

    @MockBean
    private PurchaseController purchaseController;

    @Test
    public void allTest() throws Exception{
        Purchase purchaseOne = new Purchase(getMockProducts());
        Purchase purchaseTwo = new Purchase(getMockProducts());
        List<Purchase> purchases = new ArrayList<>();
        purchases.add(purchaseOne);
        purchases.add(purchaseTwo);

        when(purchaseController.all()).thenReturn(purchases);

        mockMvc.perform(get("/purchases"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].products[0].name",
                        is("Dark chocolate")));
        verify(purchaseController).all();
        verifyNoMoreInteractions(purchaseController);
    }

    @Test
    public void newPurchaseTest() throws Exception{
        Cart cart = new Cart();
        cart.setProducts(getMockProducts());
        Purchase purchase = new Purchase(getMockProducts());

        when(purchaseController.newPurchase(cart)).thenReturn(purchase);

        mockMvc.perform(post("/purchases")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsString(cart)))
                .andExpect(jsonPath("$.products[0].name", is("Dark chocolate")))
                .andExpect(status().isOk());
        verify(purchaseController).newPurchase(cart);
        verifyNoMoreInteractions(purchaseController);
    }

    @Test
    public void oneTest() throws Exception{
        Purchase purchase = new Purchase(getMockProducts());
        purchase.setId(10L);

        when(purchaseController.one(purchase.getId())).thenReturn(purchase);

        mockMvc.perform(get("/purchases/{id}", purchase.getId()))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.products[0].name", is("Dark chocolate")));

        verify(purchaseController).one(purchase.getId());
        verifyNoMoreInteractions(purchaseController);
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