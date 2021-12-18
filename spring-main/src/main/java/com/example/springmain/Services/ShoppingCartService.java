package com.example.springmain.Services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.example.springmain.Models.CartItem;
import com.example.springmain.Models.Manga;
import com.example.springmain.Models.User;
import com.example.springmain.Repositories.CartItemRepository;
import com.example.springmain.Repositories.MangaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface ShoppingCartService {

    Map<Manga, Integer> getMangasInCart();
    
    //edit this
    public void addProduct(Long userID, int quantity, Long productID);

    //edit this
    public void removeProduct(Long customerID, int quantity, Long productID);

    //edit this
    public void updateQuantity(int quantity, Long customerID, Long productID);

    BigDecimal getTotal();
}
