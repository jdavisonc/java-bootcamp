package com.example.sk.javabootcamp.skjavabootcamp.controllers;

import com.example.sk.javabootcamp.skjavabootcamp.models.Category;
import com.example.sk.javabootcamp.skjavabootcamp.repositories.CategoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.fail;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CategoryControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private CategoryController categoryController;

    @Mock
    private CategoryRepository categoryRepository;

    @Test
    public void allTest() throws Exception {
        Category meat = new Category("meat");
        Category fruit = new Category("fruit");
        List<Category> categories = new ArrayList<>();
        categories.add(meat);
        categories.add(fruit);

        given(categoryController.all()).willReturn(categories);
        this.mockMvc.perform(get("/categories"))
                .andExpect(status().isOk());
    }

    @Test
    public void newCategoryTest() throws Exception{
        this.mockMvc.perform(post("/categories")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"meat\"\n" +"\n" +"}"))
                .andExpect(status().isOk());


    }
    @Test
    public void getByNametest() throws Exception{
        Category meat = new Category("meat");
        given(categoryController.categoryByName("name")).willReturn(meat);

        this.mockMvc.perform(get("/categories/name/{name}", "meat"))
                .andExpect(status().isOk());
    }

    @Test
    public void oneTest() throws Exception{
        this.mockMvc.perform(get("/categories/{id}", 1)).andExpect(status().isOk());
    }

    @Test
    public void replaceCategoryTest() throws Exception{
        Category meat = new Category("meat");
        given(categoryRepository.findById(anyLong())).willReturn(Optional.of(meat));

        this.mockMvc.perform(put("/categories/{id}", 1)
        .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"fruit\"}"))
                .andExpect(status().isOk());

    }

    @Test
    public void deleteCategory() {
    }

    @Test
    public void productsByCategorie() {
    }
}