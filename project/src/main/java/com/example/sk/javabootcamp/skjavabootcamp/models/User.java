package com.example.sk.javabootcamp.skjavabootcamp.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Data
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;
    @Column(unique = true)
    private String email;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Purchase> purchases = new HashSet<>();
    @OneToOne (cascade = CascadeType.ALL)
    private Cart cart = new Cart();

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Set<Product> getRecommendedProducts(){

        Set<Product> products = new HashSet<>();

        for(Purchase purchase : this.purchases){
            for(Product product : purchase.getProducts()){
                products.add(product);
            }
        }

        return products;
    }


}
