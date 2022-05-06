package com.example.candleshopapplication.web;

import com.example.candleshopapplication.model.Material;
import com.example.candleshopapplication.service.MaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/materials")
@CrossOrigin(origins = "http://localhost:3000")
public class MaterialController {

    private final MaterialService materialService;

    @GetMapping
    public List<Material> listAll() {
        return materialService.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Material> getById (@PathVariable Integer id) {
        return materialService.getById(id)
                .map(material -> ResponseEntity.ok().body(material))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
