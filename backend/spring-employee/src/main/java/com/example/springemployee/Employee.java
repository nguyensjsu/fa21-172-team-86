package com.example.springemployee;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Index;
import javax.annotation.processing.Generated;
import javax.persistence.Column;

@Entity
@Table(name="Employee")
@Data
@RequiredArgsConstructor
public class Employee {

    private @Id @GeneratedValue Long id;

    @Column(nullable=false) private String employeeID ;
    @Column(nullable=false) private String firstName ;
    @Column(nullable=false) private String lastName ;
    @Column(nullable=false) private String password ;

}
