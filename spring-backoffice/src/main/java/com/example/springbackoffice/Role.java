package com.example.springbackoffice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="ROLE")
@Data
@RequiredArgsConstructor
public class Role {
    private static final GenerationType strategy = null;

    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO) 
    private Long id;

    @Column(nullable=false) 
    private String role;

    @Column(nullable=false) 
    private String role_description;
}
