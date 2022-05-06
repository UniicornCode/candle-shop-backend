package com.example.candleshopapplication.security.jwt.response;

public class MessageResponse extends RuntimeException{

    public MessageResponse(String message) {
        super(message);
    }
}
