package com.example.candleshopapplication.web;

import com.example.candleshopapplication.model.Order;
import com.example.candleshopapplication.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public List<Order> listAll () {
        return orderService.listAll();
    }

    @PostMapping
    public ResponseEntity<Order> create () {
        UserDetails userDetails =
                (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return orderService.create(userDetails.getUsername())
                .map(order -> ResponseEntity.ok().body(order))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
