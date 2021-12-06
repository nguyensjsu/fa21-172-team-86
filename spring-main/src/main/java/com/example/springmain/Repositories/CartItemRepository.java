<<<<<<< Updated upstream
=======
/*
>>>>>>> Stashed changes
package com.example.springmain.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.example.springmain.Models.CartItem;
<<<<<<< Updated upstream
import com.example.springmain.Models.Customer;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    List<CartItem> findByCustomer(Customer customer);
    
}
=======
import com.example.springmain.Models.ShoppingCart;

@Repository
interface CartItemRepository extends JpaRepository<CartItem, Long> {
    public ArrayList<CartItem> findByCart(ShoppingCart cart);
}
*/
>>>>>>> Stashed changes
