package com.example.springmain.Models;

import javax.persistence.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="SHOPPING_CART")
@Data
@RequiredArgsConstructor
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    private Long id;

    @Column(nullable = false)
    private String email;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<CartItem> items;
}