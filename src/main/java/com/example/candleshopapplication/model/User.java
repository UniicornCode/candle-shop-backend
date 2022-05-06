package com.example.candleshopapplication.model;

import com.example.candleshopapplication.model.enumeration.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity @Data @NoArgsConstructor
@Table(name = "users")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String name;

    private String surname;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String address;

    public User(String username, String name, String surname, String password, Role role, String address) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.role = role;
        this.address = address;
    }

}
