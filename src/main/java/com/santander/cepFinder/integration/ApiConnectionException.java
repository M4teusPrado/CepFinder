package com.santander.cepFinder.integration;

import org.springframework.http.HttpStatus;

public class ApiConnectionException extends Exception {

    private final Integer code = HttpStatus.INTERNAL_SERVER_ERROR.value();

    public ApiConnectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public Integer getCode() {
        return code;
    }
}
