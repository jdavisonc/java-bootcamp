package com.example.sk.javabootcamp.skjavabootcamp.models;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")

@Data
@EqualsAndHashCode(exclude = {"products"})
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String name;


    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    @JsonBackReference
    private Set<Product> products = new HashSet<>();

    public Category(String name) {
        this.name = name;
    }

}
