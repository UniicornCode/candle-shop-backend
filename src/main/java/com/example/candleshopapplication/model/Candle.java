package com.example.candleshopapplication.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity @Data @NoArgsConstructor
public class Candle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer price;

    private String name;

    private String imgUrl;

    @ManyToMany
    private List<Material> materials;

    public Candle(Integer price, String name, String imgUrl, List<Material> materials) {
        this.price = price;
        this.name = name;
        this.imgUrl = imgUrl;
        this.materials = materials;
    }

    public Integer getId() {
        return id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public List<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }
}
