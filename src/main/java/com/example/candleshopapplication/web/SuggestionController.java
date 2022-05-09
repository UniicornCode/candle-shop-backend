package com.example.candleshopapplication.web;

import com.example.candleshopapplication.model.Suggestion;
import com.example.candleshopapplication.model.dto.SuggestionDto;
import com.example.candleshopapplication.service.SuggestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/suggestions")
@CrossOrigin(origins = "http://localhost:3000")
public class SuggestionController {

    private final SuggestionService suggestionService;

    @GetMapping
    public List<Suggestion> listAll () {
        return suggestionService.listAll();
    }

    @PostMapping
    public ResponseEntity<Suggestion> create (@RequestBody SuggestionDto text) {
        UserDetails userDetails =
                (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return suggestionService.create(userDetails.getUsername(), text.getText())
                .map(suggestion -> ResponseEntity.ok().body(suggestion))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
