package com.example.candleshopapplication.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity @Data @NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private User user;

    @ManyToMany
    private List<Candle> candles;

    public Order(User user, List<Candle> candles) {
        this.user = user;
        this.candles = candles;
    }

    public Integer getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Candle> getCandles() {
        return candles;
    }

    public void setCandles(List<Candle> candles) {
        this.candles = candles;
    }
}
