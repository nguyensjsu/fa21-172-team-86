package com.example.springmanga;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Repository
interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long> {
    ShoppingCart findByCartId(Long cartId);
    ShoppingCart findByEmail(String email);
}