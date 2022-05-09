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

    private String username;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Candle> candles;

    public Order(String username, List<Candle> candles) {
        this.username = username;
        this.candles = candles;
    }

}
