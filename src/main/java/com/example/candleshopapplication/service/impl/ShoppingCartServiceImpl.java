package com.example.candleshopapplication.service.impl;

import com.example.candleshopapplication.model.Candle;
import com.example.candleshopapplication.model.ShoppingCart;
import com.example.candleshopapplication.model.User;
import com.example.candleshopapplication.repository.CandleRepository;
import com.example.candleshopapplication.repository.ShoppingCartRepository;
import com.example.candleshopapplication.repository.UserRepository;
import com.example.candleshopapplication.service.ShoppingCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final UserRepository userRepository;
    private final CandleRepository candleRepository;

    @Override
    public List<Candle> getShoppingCart(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        if(shoppingCartRepository.getShoppingCartByUser(user).isEmpty()) {
            ShoppingCart shoppingCart = new ShoppingCart(new ArrayList<>(), user);
            shoppingCartRepository.save(shoppingCart);
            return new ArrayList<>();
        }
        else {
            return shoppingCartRepository.getShoppingCartByUser(user).get().getCandles();
        }
    }

    @Override
    public void create(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        ShoppingCart shoppingCart = new ShoppingCart(new ArrayList<>(), user);
        shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public Optional<ShoppingCart> update(String username, Integer candle) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        System.out.println(candle);
        Candle candleInCart = candleRepository.getById(candle);
        ShoppingCart shoppingCart = shoppingCartRepository.getShoppingCartByUser(user)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        List<Candle> candles = shoppingCart.getCandles();
        candles.add(candleInCart);
        shoppingCart.setCandles(candles);
        return Optional.of(shoppingCartRepository.save(shoppingCart));
    }
}
