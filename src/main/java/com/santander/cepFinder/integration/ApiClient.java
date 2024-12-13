package com.santander.cepFinder.integration;

import com.santander.cepFinder.dto.response.CepResponseDTO;

public interface ApiClient {
    CepResponseDTO getCep(String cep);
}
