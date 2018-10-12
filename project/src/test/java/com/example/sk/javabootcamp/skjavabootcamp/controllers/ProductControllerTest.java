package com.example.sk.javabootcamp.skjavabootcamp.controllers;

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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    ObjectMapper mapper = new ObjectMapper();


    @Autowired
    MockMvc mockMvc;

    @MockBean
    private ProductController productController;

    @Test
    public void allTest() throws Exception {
        when(productController.all()).thenReturn(getMockProducts());

        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is("White chocolate")))
                .andExpect(jsonPath("$[1].name", is("Dark chocolate")));
        verify(productController).all();
        verifyNoMoreInteractions(productController);
    }

    @Test
    public void newCategoryTest() throws Exception{
        Product computer = new Product("Computer", 200L, "A powerful pc", new Category("electronics"));
        when(productController.newProduct(computer)).thenReturn(computer);

        mockMvc.perform(post("/products")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsString(computer)))
                .andExpect(status().isOk());
        verify(productController).newProduct(computer);
        verifyNoMoreInteractions(productController);

    }

    @Test
    public void oneTest() throws Exception{
        Product computer = new Product("Computer", 200L, "A powerful pc", new Category("electronics"));
        when(productController.one(computer.getName())).thenReturn(computer);

        mockMvc.perform(get("/products/{name}", computer.getName()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(computer.getName())));

        verify(productController).one(computer.getName());
        verifyNoMoreInteractions(productController);
    }

    @Test
    public void replaceProductTest() throws Exception{
        Product computer = new Product("Computer", 200L, "A powerful pc", new Category("electronics"));
        Product macbook = new Product("macbook", 200222L, "A powerful pc", new Category("electronics"));

        when(productController.replaceProduct(macbook, computer.getName())).thenReturn(macbook);

        mockMvc.perform(put("/products/{name}", computer.getName())
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsString(macbook)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(macbook.getName())));

        verify(productController).replaceProduct(macbook, computer.getName());
        verifyNoMoreInteractions(productController);

    }

    @Test
    public void deleteProductTest() throws Exception{
        Product computer = new Product("Computer", 200L, "A powerful pc", new Category("electronics"));

        doNothing().when(productController).deleteProduct(computer.getName());

        mockMvc.perform(delete("/products/{name}", computer.getName()))
                .andExpect(status().isOk());
        verify(productController).deleteProduct(computer.getName());
        verifyNoMoreInteractions(productController);
    }

    public List<Product> getMockProducts() {
        Category category = new Category("chocolate");
        List<Product> products = new ArrayList<>();
        Product dark = new Product("Dark chocolate", 150L, "", category);
        Product white = new Product("White chocolate", 180L, "", category);
        products.add(white);
        products.add(dark);
        return products;
    }
}