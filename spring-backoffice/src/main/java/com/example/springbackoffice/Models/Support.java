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

import org.hibernate.annotations.ManyToAny;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import lombok.Data;
import lombok.RequiredArgsConstructor;

//used for users needing help/support
@Entity
@Table(name="SUPPORT")
@Data
@RequiredArgsConstructor
public class Support {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String description;


}
