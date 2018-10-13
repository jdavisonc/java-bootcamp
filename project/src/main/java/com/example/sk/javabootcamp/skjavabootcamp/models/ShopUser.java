package com.example.sk.javabootcamp.skjavabootcamp.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "Id")
@Data
@Entity
@Table(name ="user")
public class ShopUser {

    @Id
    @GeneratedValue
    @EqualsAndHashCode.Exclude
    private Long id;

    @Column(unique = true)
    private String username;
    private String password;

    @Column(unique = true)
    private String email;
    @EqualsAndHashCode.Exclude
    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private Set<Purchase> purchases = new HashSet<>();
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne (mappedBy = "user" , cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private Cart cart = new Cart();

    public ShopUser(String username, String password, String email) {
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
