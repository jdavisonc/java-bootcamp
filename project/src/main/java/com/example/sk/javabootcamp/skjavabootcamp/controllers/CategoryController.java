package com.example.sk.javabootcamp.skjavabootcamp.controllers;

import com.example.sk.javabootcamp.skjavabootcamp.exceptions.CategoryNotFoundException;
import com.example.sk.javabootcamp.skjavabootcamp.models.Category;
import com.example.sk.javabootcamp.skjavabootcamp.models.Product;
import com.example.sk.javabootcamp.skjavabootcamp.repositories.CategoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@RestController
public class CategoryController {

    private final CategoryRepository categoryRepository;

    CategoryController(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/categories")
    List<Category> all(){
        return categoryRepository.findAll();
    }

    @PostMapping("/categories")
    Category newCategory(@RequestBody Category newCategory){
        return categoryRepository.save(newCategory);
    }

    @GetMapping("categories/{name}")
    Category one(@PathVariable("name") String name){
        return categoryRepository.findCategoryByName(name)
                .orElseThrow(() -> new CategoryNotFoundException(name));
    }

    @PutMapping("/categories/{name}")
    Category replaceCategory(@RequestBody Category newCategory ,@PathVariable("name") String name){
        return categoryRepository.findCategoryByName(name)
                .map(category -> {
                    category.setName(newCategory.getName());
                    return categoryRepository.save(category);
                })
                .orElseGet(() -> categoryRepository.save(newCategory));
    }

    @DeleteMapping("/categories/{name}")
    void deleteCategoryByName(@PathVariable("name") String name){
        categoryRepository.deleteCategoryByName(name);
    }

    @GetMapping("/categories/{name}/products")
    Set<Product> productsByCategorie(@PathVariable("name") String name){
        Category category = one(name);
        return  category.getProducts();
    }

}
