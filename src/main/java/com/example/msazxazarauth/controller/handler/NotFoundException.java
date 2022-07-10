package com.example.msazxazarauth.controller.handler;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {

    private final String code;

    public NotFoundException(String message, String code) {
        super(message);
        this.code = code;
    }
}
