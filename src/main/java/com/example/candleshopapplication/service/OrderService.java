package com.example.candleshopapplication.service;

import com.example.candleshopapplication.model.Candle;
import com.example.candleshopapplication.model.Order;
import com.example.candleshopapplication.model.User;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<Order> listAll();
    Optional<Order> create(String username);
}
