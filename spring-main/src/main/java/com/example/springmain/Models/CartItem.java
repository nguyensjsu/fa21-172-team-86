package com.example.springmain.Models;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import com.example.springmain.Models.*;


@Entity
@Table(name = "Cart_Item")
@Data
@RequiredArgsConstructor
public class CartItem {
    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @ManyToOne
    private Manga manga;

    @ManyToOne
    private ShoppingCart shoppingCart;

    private int quantity;
}