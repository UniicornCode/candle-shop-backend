package com.example.candleshopapplication.web;

import com.example.candleshopapplication.model.Candle;
import com.example.candleshopapplication.model.ShoppingCart;
import com.example.candleshopapplication.model.dto.IdDto;
import com.example.candleshopapplication.service.ShoppingCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/shopping-cart")
@CrossOrigin(origins = "http://localhost:3000")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;


    @GetMapping
    public List<Candle> getCandlesInShoppingCart() {
        UserDetails userDetails =
                (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return shoppingCartService.getShoppingCart(userDetails.getUsername());
    }

    @PostMapping("/add")
    public ResponseEntity<ShoppingCart> updateShoppingCart (@RequestBody IdDto candle) {
        UserDetails userDetails =
                (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return shoppingCartService.update(userDetails.getUsername(), candle.getCandle())
                .map(shoppingCart -> ResponseEntity.ok().body(shoppingCart))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
