
package com.example.springmain.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import com.example.springmain.Models.CartItem;
import com.example.springmain.Models.ShoppingCart;
import com.example.springmain.Models.User;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    //remove later
    public List<CartItem> findByShoppingCart(ShoppingCart cart);

    public List<CartItem> findByUser(User user);

    //public void deleteByCustomerAndProduct(Long customerID, Long productID);

    //public void updateQuantity(int quantity, Long customerID, Long productID);
}
