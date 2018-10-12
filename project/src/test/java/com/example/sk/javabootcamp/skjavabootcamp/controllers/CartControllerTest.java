package com.example.sk.javabootcamp.skjavabootcamp.controllers;

import com.example.sk.javabootcamp.skjavabootcamp.models.Cart;
import com.example.sk.javabootcamp.skjavabootcamp.models.Category;
import com.example.sk.javabootcamp.skjavabootcamp.models.Product;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CartControllerTest {

    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private CartController cartController;

    @Test
    public void allTest() throws Exception {
        Set<Product> products = getMockProducts();
        Cart cart1 = new Cart();
        Cart cart2 = new Cart();
        cart1.setProducts(products);
        cart2.setProducts(products);

        List<Cart> carts = new ArrayList<>();
        carts.add(cart1);
        carts.add(cart2);

        when(cartController.all()).thenReturn(carts);


        this.mockMvc.perform(get("/carts"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].products[0].name", is("Dark chocolate")))
                .andExpect(jsonPath("$[1].products[1].name", is("White chocolate")));

        verify(cartController).all();
        verifyNoMoreInteractions(cartController);
    }

    @Test
    public void oneTest() throws Exception {
        Long id = 10L;
        Cart mockCart = new Cart();
        mockCart.setId(id);

        when(cartController.one(id)).thenReturn(mockCart);

        this.mockMvc.perform(get("/carts/{id}", id))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id", is(id.intValue())));

        verify(cartController).one(id);
        verifyNoMoreInteractions(cartController);
    }

    @Test
    public void emptyCart() throws Exception {
        Long id = 10L;
        Cart mockCart = new Cart();
        mockCart.setId(id);
        mockCart.setProducts(getMockProducts());
        Cart empty = new Cart();

        when(cartController.emptyCart(id)).thenReturn(empty);

        mockMvc.perform(delete("/carts/{id}", id))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.products", hasSize(0)));

        verify(cartController).emptyCart(id);
        verifyNoMoreInteractions(cartController);
    }

    @Test
    public void addProduct() throws Exception {
        Long id = 10L;
        Cart mockCart = new Cart();
        mockCart.setId(id);
        Product white = new Product("White chocolate", 10L, "", new Category("chocolate"));

        Cart fullCart = new Cart();
        fullCart.setId(id);
        fullCart.addProduct(white);
        when(cartController.addProduct(id, white)).thenReturn(fullCart);

        mockMvc.perform(post("/carts/{id}", id)
                .content(mapper.writeValueAsString(white))
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.products", hasSize(1)))
                .andExpect(jsonPath("$.products[0].name", is("White chocolate")));
        verify(cartController).addProduct(id, white);
        verifyNoMoreInteractions(cartController);

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