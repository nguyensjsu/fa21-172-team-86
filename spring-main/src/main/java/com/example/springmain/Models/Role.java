package com.example.springmain.Models;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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

    @Column(unique = true)
    private String role;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "roles")
    private Collection<User> users;
    

    @Column(nullable = false)
    private String name;

    public Role(String name) {
        this.name = name;
    }
     
    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }
 
    public Role(Long id) {
        this.id = id;
    }
     
 
    @Override
    public String toString() {
        return this.name;
    }

}