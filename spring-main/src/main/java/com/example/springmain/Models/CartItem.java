package com.example.springmain.Models;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;


import lombok.Data;
import lombok.RequiredArgsConstructor;


@Entity
@Table(name = "Cart_Item")
@Data
@RequiredArgsConstructor
public class CartItem {
    private @Id @GeneratedValue(strategy=GenerationType.IDENTITY) Long itemID;
    
    private String manga;

    private String cart;

    private Integer amount;
}