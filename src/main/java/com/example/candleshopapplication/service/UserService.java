package com.example.candleshopapplication.service;

import com.example.candleshopapplication.security.jwt.request.SignupRequest;

public interface UserService {

    void register(SignupRequest signupRequest);
}
