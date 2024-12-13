package com.santander.cepFinder.dto.response.error;

import com.santander.cepFinder.dto.response.error.base.ErrorSearchCep;
import com.santander.cepFinder.integration.CepNotFoundException;

public class ErrorCepNotFound extends ErrorSearchCep {
    public ErrorCepNotFound(CepNotFoundException ex) {
        super("Erro ao buscar o CEP: " + ex.getMessage() + ". Verifique se o CEP está correto.", ex.getCode());
    }
}


