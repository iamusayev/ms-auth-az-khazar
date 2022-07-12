package com.example.msazxazarauth.exception;

import org.springframework.security.access.AccessDeniedException;

public class ForbiddenException extends AccessDeniedException {


    private final String code;

    public ForbiddenException(String msg, String code) {
        super(msg);
        this.code = code;
    }
}
