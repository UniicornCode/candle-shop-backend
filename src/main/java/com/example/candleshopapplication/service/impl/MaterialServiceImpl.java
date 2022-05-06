package com.example.candleshopapplication.service.impl;

import com.example.candleshopapplication.model.Material;
import com.example.candleshopapplication.repository.MaterialRepository;
import com.example.candleshopapplication.service.MaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MaterialServiceImpl implements MaterialService {

    private final MaterialRepository materialRepository;

    @Override
    public List<Material> listAll() {
        return materialRepository.findAll();
    }

    @Override
    public Optional<Material> getById(Integer id) {
        return materialRepository.findById(id);
    }
}
