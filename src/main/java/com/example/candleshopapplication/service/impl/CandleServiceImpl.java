package com.example.candleshopapplication.service.impl;

import com.example.candleshopapplication.model.Candle;
import com.example.candleshopapplication.model.Material;
import com.example.candleshopapplication.model.dto.CandleDto;
import com.example.candleshopapplication.repository.CandleRepository;
import com.example.candleshopapplication.repository.MaterialRepository;
import com.example.candleshopapplication.service.CandleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CandleServiceImpl implements CandleService {

    private final CandleRepository candleRepository;
    private final MaterialRepository materialRepository;

    @Override
    public List<Candle> listAll() {
        return candleRepository.findAll();
    }

    @Override
    public Optional<Candle> findById(Integer id) {
        return candleRepository.findById(id);
    }

    @Override
    public Optional<Candle> create(CandleDto candleDto) {
        List<Integer> mat = new ArrayList<>();
        for(String s : candleDto.getMaterials()) mat.add(Integer.valueOf(s));
        List<Material> materials = materialRepository.findAllById(mat);
        Candle candle = new Candle(candleDto.getPrice(), candleDto.getName(),
                candleDto.getImgUrl(), materials);
        return Optional.of(candleRepository.save(candle));
    }

    @Override
    public Optional<Candle> edit(Integer id, CandleDto candleDto) {
        Candle candle = candleRepository.findById(id).orElseThrow(ExceptionInInitializerError::new);
        candle.setPrice(candleDto.getPrice());
        candle.setImgUrl(candleDto.getImgUrl());
        candle.setName(candle.getName());
        List<Integer> mat = new ArrayList<>();
        for(String s : candleDto.getMaterials()) mat.add(Integer.valueOf(s));
        List<Material> materials = materialRepository.findAllById(mat);
        candle.setMaterials(materials);
        return Optional.of(candleRepository.save(candle));
    }

    @Override
    public void delete(Integer id) {
        Candle candle = candleRepository.getById(id);
        candleRepository.delete(candle);
    }
}
