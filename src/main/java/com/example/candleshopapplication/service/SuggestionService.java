package com.example.candleshopapplication.service;

import com.example.candleshopapplication.model.Suggestion;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface SuggestionService {

    List<Suggestion> listAll();

    Optional<Suggestion> create(String username, String text);
}
