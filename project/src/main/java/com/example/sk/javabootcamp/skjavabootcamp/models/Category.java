package com.example.sk.javabootcamp.skjavabootcamp.models;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")

@Data
@EqualsAndHashCode(exclude = {"products"})
@Entity
public class Category {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany(mappedBy = "category")
    @JsonBackReference
    private Set<Product> products = new HashSet<>();

    public Category(String name) {
        this.name = name;
    }

}
