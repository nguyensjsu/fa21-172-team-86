package com.example.springmain.Models;

import javax.persistence.Entity;

import java.beans.Transient;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "Shopping_Cart" )
@Data
@RequiredArgsConstructor
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    private Long cartId;

    @Column(nullable=false) 
    private User user;
    
    private Double totalPrice;

    private int totalItems;

    //@OneToMany(cascade = CascadeType.ALL)
    //private Set<CartItem> items;

    private String tokenSession;


}