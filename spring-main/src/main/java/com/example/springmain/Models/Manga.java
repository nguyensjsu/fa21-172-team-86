package com.example.springmain.Models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name="Manga")
@Data
@RequiredArgsConstructor
public class Manga {
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private  Long id;

    private String isbn;                                 //I propose that we use the ISBN-13 of the mangas to be the primary-key

    private String manga_title;

    private String description;

    private String author;

    private double price;

    private int stock;

}
