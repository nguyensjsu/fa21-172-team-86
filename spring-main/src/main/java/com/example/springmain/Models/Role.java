package com.example.springmain.Models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="ROLE")
@Data
@RequiredArgsConstructor
public class Role {
    
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String roles;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "roles")
    private List<User> users;

}