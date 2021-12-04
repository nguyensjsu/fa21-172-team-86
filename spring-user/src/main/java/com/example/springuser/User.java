package com.example.springuser;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.persistence.Column;

import lombok.Data;
import lombok.RequiredArgsConstructor;


@Entity
@Table(name="USER")
@Data
@RequiredArgsConstructor
public class User {

    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO) 
    private Long id;

    @NotNull
    @Column(nullable=false) 
    private String firstName;

    @NotNull
    @Column(nullable=false) 
    private String lastName;

    @NotNull
    @Column(nullable=false) 
    private String email;

    @NotNull
    @Column(nullable=false) 
    private String password;

    @NotNull
    @Column(nullable=false) 
    private String role;

}
