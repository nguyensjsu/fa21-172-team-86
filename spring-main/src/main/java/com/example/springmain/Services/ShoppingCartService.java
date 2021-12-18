package com.example.springmain.Services;

import java.util.List;

import com.example.springmain.Models.CartItem;
import com.example.springmain.Models.User;
import com.example.springmain.Repositories.CartItemRepository;
import com.example.springmain.Repositories.MangaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartService {
    @Autowired
    private CartItemRepository cartItemRepo;
    //@Autowired
    //private MangaRepository mangaRepo;

    public List<CartItem> listCartItems(User user){
        return cartItemRepo.findByUser(user);
    }

    //edit this
    public void addProduct(Long userID, int quantity, Long productID){
        
    }

    //edit this
    public void removeProduct(Long customerID, int quantity, Long productID){

    }

    //edit this
    public void updateQuantity(int quantity, Long customerID, Long productID){

    }
}
