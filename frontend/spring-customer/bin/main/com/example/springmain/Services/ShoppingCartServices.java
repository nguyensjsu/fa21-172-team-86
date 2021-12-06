package com.example.springmain.Services;

import java.util.List;

import com.example.springmain.Models.CartItem;
import com.example.springmain.Models.Customer;
import com.example.springmain.Repositories.CartItemRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class ShoppingCartServices {
    @Autowired
    private CartItemRepository cartRepo;

    public List<CartItem> listCartItems(Customer customer)
    {
        return cartRepo.findByCustomer(customer);
    }

}
