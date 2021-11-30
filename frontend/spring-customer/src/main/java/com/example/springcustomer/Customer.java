package main.java.com.example.springcustomer;

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
@Table(name="Customer")
@Data
@RequiredArgsConstructor
public class Customer {

    private @Id @GeneratedValue Long id;

    @Column(nullable=false) private String email ;
    @Column(nullable=false) private String firstName ;
    @Column(nullable=false) private String lastName ;
    @Column(nullable=false) private String password ;
    
}
