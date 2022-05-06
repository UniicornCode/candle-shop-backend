package com.example.candleshopapplication.repository;

import com.example.candleshopapplication.model.Candle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandleRepository extends JpaRepository<Candle, Integer> {
}
