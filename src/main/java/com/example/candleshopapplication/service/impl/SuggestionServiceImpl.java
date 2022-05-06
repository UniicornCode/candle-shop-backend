package com.example.candleshopapplication.service.impl;

import com.example.candleshopapplication.model.Suggestion;
import com.example.candleshopapplication.repository.SuggestionRepository;
import com.example.candleshopapplication.service.SuggestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SuggestionServiceImpl implements SuggestionService {

    private final SuggestionRepository suggestionRepository;

    @Override
    public List<Suggestion> listAll() {
        return suggestionRepository.findAll();
    }

    @Override
    public Optional<Suggestion> create(String username, String text) {
        Suggestion suggestion = new Suggestion(username, text);
        return Optional.of(suggestionRepository.save(suggestion));
    }


}
