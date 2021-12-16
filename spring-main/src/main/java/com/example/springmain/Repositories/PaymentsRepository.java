package com.example.springmain.Repositories;

import com.example.springmain.Models.ShoppingCart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PaymentsRepository extends CrudRepository<ShoppingCart, Long> {

}