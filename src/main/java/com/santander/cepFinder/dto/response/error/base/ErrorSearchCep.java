package com.santander.cepFinder.dto.response.error.base;

public abstract class ErrorSearchCep extends Exception implements InterfaceSearchCepError {

    private final int errorCode;

    public ErrorSearchCep(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    @Override
    public int getErrorCode() {
        return errorCode;
    }

    @Override
    public String getErrorMessage() {
        return getMessage();
    }
}
