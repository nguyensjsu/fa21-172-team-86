package com.example.springuser.Models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ManyToAny;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
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

    @Column(nullable=false) 
    private String firstName;

    @Column(nullable=false) 
    private String lastName;

    @Column(nullable=false) 
    private String email;

    @Column(nullable=false) 
    private String password;

    @Column(nullable=false) 
    private String role;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_role" , 
            joinColumns = @JoinColumn(name= "user_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name= "role_id",referencedColumnName = "id")) 
    private Set<Role> roles;
    
/*
    private void setRoles(Set<Role> roles){
        this.roles = roles;
    }

    private void addRole(Role role){
        this.roles.add(role);
    }
*/  
}
