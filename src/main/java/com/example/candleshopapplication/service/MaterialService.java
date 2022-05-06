package com.example.candleshopapplication.service;

import com.example.candleshopapplication.model.Material;

import java.util.List;
import java.util.Optional;

public interface MaterialService {

    List<Material> listAll();
    Optional<Material> getById(Integer id);
}
