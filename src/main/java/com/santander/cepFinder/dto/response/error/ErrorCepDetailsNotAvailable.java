package com.santander.cepFinder.dto.response.error;

import com.santander.cepFinder.dto.response.error.base.ErrorSearchCep;
import com.santander.cepFinder.integration.CepDetailsNotAvailableException;

public class ErrorCepDetailsNotAvailable extends ErrorSearchCep {
    public ErrorCepDetailsNotAvailable(CepDetailsNotAvailableException ex) {
        super("ERRO: " + ex.getMessage(), ex.getCode());
    }
}


