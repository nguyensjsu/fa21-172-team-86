package com.example.springbackoffice.Models;

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
            name = "user_roles" , 
            joinColumns = @JoinColumn(name= "user_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name= "role_id",referencedColumnName = "id")) 
    private List<Role> roles;

}
