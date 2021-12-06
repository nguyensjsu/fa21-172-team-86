
package com.example.springmain.Services;

import java.util.List;

import com.example.springmain.Models.CartItem;
import com.example.springmain.Models.User;
import com.example.springmain.Repositories.CartItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServices {
    @Autowired
    private CartItemRepository cartRepo;

    //public List<CartItem> listCartItems(User user){
    //    return cartRepo.findByUser(user);
    //}
}