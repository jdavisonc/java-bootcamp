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

    @GetMapping("categories/{id}")
    Category one(@PathVariable Long id){
        return categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(id));
    }

    @PutMapping("/categories/{id}")
    Category replaceCategory(@RequestBody Category newCategory ,@PathVariable Long id){
        return categoryRepository.findById(id)
                .map(category -> {
                    category.setName(newCategory.getName());
                    return categoryRepository.save(category);
                })
                .orElseGet(() -> {
                    newCategory.setId(id);
                    return categoryRepository.save(newCategory);
                });
    }

    @DeleteMapping("/categories/{id}")
    void deleteCategory(@PathVariable Long id){
        categoryRepository.deleteById(id);
    }

    @GetMapping("/categories/{id}/productos")
    Set<Product> productsByCategorie(@PathVariable Long id){
        Category category = one(id);
        return  category.getProducts();
    }

}
