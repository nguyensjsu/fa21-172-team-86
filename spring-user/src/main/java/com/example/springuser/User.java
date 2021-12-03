package com.example.springuser;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

import lombok.Data;
import lombok.RequiredArgsConstructor;


/*

Email - Username

*/

@Entity
@Table(name="User")
@Data
@RequiredArgsConstructor
public class User {

    private @Id @GeneratedValue(strategy=GenerationType.AUTO) Long id;

    @Column(nullable=false) private String firstName;
    @Column(nullable=false) private String lastName;
    @Column(nullable=false) private String email;
    @Column(nullable=false) private String password;
    @Column(nullable=false) private String role;

}
