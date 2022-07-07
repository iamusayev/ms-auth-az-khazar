package com.example.msazxazarauth.model.constants;

import lombok.Data;
import lombok.Getter;


@Getter
public class ExceptionConstants {

    public static final String UNEXPECTED_EXCEPTION_CODE = "UNEXPECTED_EXCEPTION";
    public static final String UNEXPECTED_EXCEPTION_MESSAGE = "Unexpected exception occurred";

    public static final String NOT_FOUND_EXCEPTION_CODE = "NOT_FOUND_EXCEPTION";
    public static final String NOT_FOUND_EXCEPTION_MESSAGE = "%s with id: %s not found";

    public static final String VALIDATION_EXCEPTION_CODE = "INVALID_MANDATORY_FIELD";
    public static final String VALIDATION_EXCEPTION_MESSAGE = "One or more required fields in the request are invalid";

    public static final String USER_ALREADY_EXIST_CODE = "USER_ALREADY_EXIST";
    public static final String USER_ALREADY_EXIST_MESSAGE = "This username is taken, please enter something else";

}
