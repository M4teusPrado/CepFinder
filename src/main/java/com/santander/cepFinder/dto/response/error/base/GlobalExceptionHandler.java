package com.santander.cepFinder.dto.response.error.base;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ErrorSearchCep.class)
    public ResponseEntity<ErrorResponse> handleErrorSearchCep(ErrorSearchCep ex) {
        ErrorResponse errorResponse = new ErrorResponse (
                ex.getErrorCode(),
                ex.getErrorMessage()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}