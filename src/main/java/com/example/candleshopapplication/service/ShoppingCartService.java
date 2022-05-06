package com.example.candleshopapplication.service;

import com.example.candleshopapplication.model.Candle;
import com.example.candleshopapplication.model.Order;
import com.example.candleshopapplication.model.ShoppingCart;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ShoppingCartService {
    List<Candle> getShoppingCart(String username);
    void create (String username);

    Optional<ShoppingCart> update (String username, Integer candle);
}
