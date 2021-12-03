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
    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String manga_id;

    private String manga_title;

    @NotNull
    @Column(nullable=false)
    private String ISBN-13;

    
}
