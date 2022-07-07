package com.example.msazxazarauth.exception;

import lombok.Getter;

@Getter
public class UserAlreadyExistException extends RuntimeException {

    private final String code;


    public UserAlreadyExistException(String message, String code) {
        super(message);
        this.code = code;
    }
}
