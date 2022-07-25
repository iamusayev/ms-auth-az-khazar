package com.example.msazxazarauth.controller.handler;

import com.example.msazxazarauth.exception.UserAlreadyExistException;
import com.example.msazxazarauth.model.constants.ExceptionConstants;
import com.example.msazxazarauth.model.dto.ExceptionDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.example.msazxazarauth.model.constants.ExceptionConstants.*;

@RestControllerAdvice
@Slf4j
public class ErrorHandler {



    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionDto handle(Exception ex) {
        log.error("Exception", ex);
        return new ExceptionDto(UNEXPECTED_EXCEPTION_CODE, UNEXPECTED_EXCEPTION_MESSAGE);
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionDto handle(NotFoundException ex) {
        log.error("Exception", ex);
        return new ExceptionDto(ex.getCode(), ex.getMessage());
    }


    @ExceptionHandler(UserAlreadyExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ExceptionDto handle(UserAlreadyExistException ex){
        log.error("Exception", ex);
        return new ExceptionDto(ex.getCode(),ex.getMessage());
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ExceptionDto handle(MethodArgumentNotValidException ex) {
        log.error("Exception ", ex);
        return new ExceptionDto(VALIDATION_EXCEPTION_CODE, VALIDATION_EXCEPTION_MESSAGE);
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ExceptionDto handle(AccessDeniedException ex){
        log.error("Exception", ex);
        return new ExceptionDto(FORBIDDEN_EXCEPTION_CODE, FORBIDDEN_EXCEPTION_MESSAGE);
    }

}
