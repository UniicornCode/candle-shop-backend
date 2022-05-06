package com.example.candleshopapplication.security.jwt.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

@Data
public class JwtResponse {

    private String accessToken;
    private String type = "Bearer";
    private Integer id;
    private String username;
    private String role;

    private String address;

    public JwtResponse(String accessToken, Integer id, String username, String role, String address) {
        this.accessToken = accessToken;
        this.id = id;
        this.username = username;
        this.role = role;
        this.address = address;
    }
}
