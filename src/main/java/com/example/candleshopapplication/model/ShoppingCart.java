package com.example.candleshopapplication.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity @Data @NoArgsConstructor
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany
    private List<Candle> candles;

    @OneToOne
    private User user;

    public ShoppingCart(List<Candle> candles, User user) {
        this.candles = candles;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public List<Candle> getCandles() {
        return candles;
    }
    public void setCandles(List<Candle> candles) {
        this.candles = candles;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
