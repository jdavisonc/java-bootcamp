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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CategoryControllerTest {

    ObjectMapper mapper = new ObjectMapper();


    @Autowired
    MockMvc mockMvc;

    @MockBean
    private CategoryController categoryController;

    @Test
    public void allTest() throws Exception {
        Category meat = new Category("meat");
        Category fruit = new Category("fruit");
        List<Category> categories = new ArrayList<>();
        categories.add(meat);
        categories.add(fruit);

        when(categoryController.all()).thenReturn(categories);

        this.mockMvc.perform(get("/categories"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is("meat")))
                .andExpect(jsonPath("$[1].name", is("fruit")));
    }

    @Test
    public void newCategoryTest() throws Exception {
        Category category = new Category("chicken");
        when(categoryController.newCategory(category)).thenReturn(category);

        this.mockMvc.perform(post("/categories")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(category)))
                .andExpect(status().isOk());
        verify(categoryController).newCategory(category);
        verifyNoMoreInteractions(categoryController);

    }

    @Test
    public void getCategoryByNameTest() throws Exception {
        Category meat = new Category("meat");
        when(categoryController.one(meat.getName())).thenReturn(meat);

        this.mockMvc.perform(get("/categories/{name}", "meat"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.name", is("meat")));

        verify(categoryController).one(meat.getName());
        verifyNoMoreInteractions(categoryController);
    }

    @Test
    public void replaceCategoryTest() throws Exception {
        Category meat = new Category("meat");
        Category fish = new Category("fish");

        when(categoryController.replaceCategory(fish, meat.getName())).thenReturn(fish);

        this.mockMvc.perform(put("/categories/{name}", "meat")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsString(fish)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("fish")));

        verify(categoryController).replaceCategory(fish, meat.getName());
        verifyNoMoreInteractions(categoryController);
    }

    @Test
    public void deleteCategoryTest() throws Exception {
        Category category = new Category("fish");

        when(categoryController.one(category.getName())).thenReturn(category);

        doNothing().when(categoryController).deleteCategoryByName(category.getName());

        this.mockMvc.perform(delete("/categories/{name}", "fish"))
                .andExpect(status().isOk());

        verify(categoryController)
                .deleteCategoryByName(category.getName());
        verifyNoMoreInteractions(categoryController);

    }

    @Test
    public void productsByCategoryTest() throws Exception {
        Category category = new Category("chocolate");
        Set<Product> products = new HashSet<>();
        Product dark = new Product("Dark chocolate", new Long(150), "", category);
        Product white = new Product("White chocolate", new Long(180), "", category);
        products.add(white);
        products.add(dark);
        category.setProducts(products);

        when(categoryController.productsByCategorie(category.getName())).thenReturn(category.getProducts());

        this.mockMvc.perform(get("/categories/{name}/products", category.getName()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is(dark.getName())))
                .andExpect(jsonPath("$[1].name", is(white.getName())));

        verify(categoryController).productsByCategorie(category.getName());
        verifyNoMoreInteractions(categoryController);
    }
}