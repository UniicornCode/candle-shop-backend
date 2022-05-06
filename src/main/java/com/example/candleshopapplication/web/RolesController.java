package com.example.candleshopapplication.web;

import com.example.candleshopapplication.model.enumeration.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/roles")
@CrossOrigin(origins = "http://localhost:3000")
public class RolesController {

    @GetMapping
    public List<Role> getRoles () {
        return List.of(Role.values());
    }
}
