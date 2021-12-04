package com.example.springmanga;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
interface CartItemRepository extends JpaRepository<CartItem, Long> {
    public ArrayList<CartItem> findByCart(ShoppingCart cart);
}