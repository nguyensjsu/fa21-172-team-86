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
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "Shopping_Cart" )
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    private Long cartId;

    private @NonNull 
    String email ;
}