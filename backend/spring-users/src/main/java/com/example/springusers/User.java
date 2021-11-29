package main.java.com.example.springusers;

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
@Table(name="Users")
@Data
@RequiredArgsConstructor
public class User {
    private @Id @GeneratedValue Long id;

    @Column(nullable=false) private String email ;
    @Column(nullable=false) private String firstName ;
    @Column(nullable=false) private String lastName ;
    @Column(nullable=false) private String password ;
}
