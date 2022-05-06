package com.example.candleshopapplication.web;

import com.example.candleshopapplication.model.Candle;
import com.example.candleshopapplication.model.dto.CandleDto;
import com.example.candleshopapplication.model.enumeration.Role;
import com.example.candleshopapplication.service.CandleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/candles")
@CrossOrigin(origins = "http://localhost:3000")
public class CandleController {

    private final CandleService candleService;

    @GetMapping
    private List<Candle> listAll() {
        return candleService.listAll();
    }

    @GetMapping("/{id}")
    private ResponseEntity<Candle> findById(@PathVariable Integer id) {
        return candleService.findById(id)
                .map(candle -> ResponseEntity.ok().body(candle))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Candle> save(@RequestBody CandleDto candleDto) {
        return this.candleService.create(candleDto)
                .map(candle -> ResponseEntity.ok().body(candle))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Candle> edit(@PathVariable Integer id, @RequestBody CandleDto candleDto) {
        return this.candleService.edit(id, candleDto)
                .map(candle -> ResponseEntity.ok().body(candle))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Candle> delete (@PathVariable Integer id) {
        this.candleService.delete(id);
        if (this.candleService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
}
