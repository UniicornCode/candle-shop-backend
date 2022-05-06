package com.example.candleshopapplication.service;

import com.example.candleshopapplication.model.Candle;
import com.example.candleshopapplication.model.Material;
import com.example.candleshopapplication.model.dto.CandleDto;

import java.util.List;
import java.util.Optional;

public interface CandleService {
    List<Candle> listAll ();
    Optional<Candle> findById (Integer id);
    Optional<Candle> create (CandleDto candleDto);
    Optional<Candle> edit (Integer id, CandleDto candleDto);
    void delete (Integer id);
}
