package com.example.springmanga.Models;

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
    private @Id @GeneratedValue(strategy=GenerationType.AUTO) Long mangaID;

    private String isbn;                                 //I propose that we use the ISBN-13 of the mangas to be the primary-key

    private String manga_title;

    private String author;

    private String description;

    private double price;

}
