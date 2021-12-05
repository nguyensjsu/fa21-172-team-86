package com.example.springmanga;

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

import com.example.springmanga.Models.*;

@Entity
@Table(name = "Cart_Item" )
@Data
@RequiredArgsConstructor
public class CartItem {
    private @Id @GeneratedValue(strategy=GenerationType.IDENTITY) Long itemID;
    
    @ManyToOne
    private Manga manga;

    @ManyToOne
    private ShoppingCart cart;

    private Integer amount;
}