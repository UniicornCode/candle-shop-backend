package com.example.candleshopapplication.repository;

import com.example.candleshopapplication.model.Suggestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuggestionRepository extends JpaRepository<Suggestion, Integer> {
}
