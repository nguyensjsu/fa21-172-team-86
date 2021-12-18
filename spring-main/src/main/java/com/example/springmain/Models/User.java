package com.example.springmain.Models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ManyToAny;

import java.util.Collection;
import java.util.HashSet;
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
    @Column(name = "user_id") 
    private Long id;

    @Column(nullable=false) 
    private String firstName;

    @Column(nullable=false) 
    private String lastName;

    @Column(nullable=false) 
    private String email;

    @Column(nullable=false) 
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Collection<Role> roles;
    
    public void addRole(Role role) {
        this.roles.add(role);
    }

    private String role;

}
