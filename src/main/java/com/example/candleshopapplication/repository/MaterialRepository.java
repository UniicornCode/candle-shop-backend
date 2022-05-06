package com.example.candleshopapplication.repository;

import com.example.candleshopapplication.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Integer> {
}
