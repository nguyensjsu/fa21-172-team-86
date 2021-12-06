package com.example.springmain.Models;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import com.example.springmain.Models.*;


@Entity
@Table(name = "Cart_Item" )
@Data
@RequiredArgsConstructor
public class CartItem {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    private Long id;
    
    
    //@ManyToOne
    //@JoinColumn (name="manga_id")
    //private Manga mangaProduct

    //@ManyToOne
    //@JoinColumn (name="customer_id")
    //private Customer customer

    private String cart;

    private int quantity;
}