package com.example.springmain.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.example.springmain.Models.CartItem;
import com.example.springmain.Models.Customer;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    List<CartItem> findByCustomer(Customer customer);
    
}