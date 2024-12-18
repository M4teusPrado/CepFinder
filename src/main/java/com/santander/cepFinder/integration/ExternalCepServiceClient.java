package com.santander.cepFinder.integration;

import com.santander.cepFinder.dto.response.CepResponseDTO;

public interface ExternalCepServiceClient {
    CepResponseDTO getDetails(String zipCode) throws ApiConnectionException, CepNotFoundException, CepDetailsNotAvailableException;
}
