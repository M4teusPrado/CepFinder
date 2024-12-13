package com.santander.cepFinder.dto.response.error;

import com.santander.cepFinder.dto.response.error.base.ErrorSearchCep;
import com.santander.cepFinder.integration.ApiConnectionException;

public class ErrorApiConnection extends ErrorSearchCep {
    public ErrorApiConnection(ApiConnectionException ex) {
        super("Erro ao conectar à API externa: " + ex.getMessage(), ex.getCode());
    }
}


