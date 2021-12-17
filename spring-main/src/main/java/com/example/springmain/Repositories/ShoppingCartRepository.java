package com.example.springmain.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

import com.example.springmain.Models.ShoppingCart;

//REMOVE THIS LATER
@Repository
public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long> {
    ShoppingCart findByid(Long id);
    ShoppingCart findByEmail(String email);
}