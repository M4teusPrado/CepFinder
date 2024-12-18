package com.santander.cepFinder.integration;

public class CepDetailsNotAvailableException extends Exception {

    private final Integer code;

    public CepDetailsNotAvailableException(String message, Integer statusCode) {
        super(message);
        this.code = statusCode;
    }

    public Integer getCode() {
        return code;
    }
}