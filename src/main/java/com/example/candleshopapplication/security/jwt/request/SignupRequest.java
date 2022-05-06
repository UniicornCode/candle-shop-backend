package com.example.candleshopapplication.security.jwt.request;

import com.example.candleshopapplication.model.enumeration.Role;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class SignupRequest {

    private String username;
    private String name;
    private String surname;
    private String password;
    private String role;
    private String address;
}
