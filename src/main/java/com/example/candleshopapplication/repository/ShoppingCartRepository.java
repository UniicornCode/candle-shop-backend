package com.example.candleshopapplication.repository;

import com.example.candleshopapplication.model.ShoppingCart;
import com.example.candleshopapplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {

    Optional<ShoppingCart> getShoppingCartByUser(User user);
}
