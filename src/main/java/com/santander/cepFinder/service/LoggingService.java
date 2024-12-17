package com.santander.cepFinder.service;

import com.santander.cepFinder.dto.response.CepResponseDTO;

public interface LoggingService {
    void logConsultaCep(CepResponseDTO response);
}
