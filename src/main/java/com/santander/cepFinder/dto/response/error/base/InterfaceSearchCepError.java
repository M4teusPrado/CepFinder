package com.santander.cepFinder.dto.response.error.base;

public interface InterfaceSearchCepError  {


    int getErrorCode();

    String getErrorMessage();

    default String getAdditionalDetails() {
        return "Sem detalhes adicionais";
    }
}

