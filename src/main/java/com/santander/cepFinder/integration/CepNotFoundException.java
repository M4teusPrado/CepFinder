package com.santander.cepFinder.integration;

public class CepNotFoundException extends Exception {

    private final Integer code;

    public CepNotFoundException(String message, Integer statusCode) {
        super(message);
        this.code = statusCode;
    }

    public Integer getCode() {
        return code;
    }
}