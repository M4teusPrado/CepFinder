package com.santander.cepFinder.integration;

import com.santander.cepFinder.dto.response.CepResponseDTO;

public interface ExternalCepServiceClient {
    CepResponseDTO getDetails(String cep) throws ApiConnectionException, CepNotFoundException;
}
