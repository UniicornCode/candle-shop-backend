package com.example.candleshopapplication.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @Data @NoArgsConstructor
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String material;

    public Integer getId() {
        return id;
    }

    public String getMaterial() {
        return material;
    }
}
