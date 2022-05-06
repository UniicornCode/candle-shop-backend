package com.example.candleshopapplication.model.dto;

import com.example.candleshopapplication.model.Material;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class CandleDto {

    private Integer price;

    private String name;

    private String imgUrl;

    @ManyToMany
    private List<String> materials;

    public CandleDto(Integer price, String name, String imgUrl, List<String> materials) {
        this.price = price;
        this.name = name;
        this.imgUrl = imgUrl;
        this.materials = materials;
    }
}
