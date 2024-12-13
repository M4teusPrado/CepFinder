package com.santander.cepFinder.integration.ApiViaCEP;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.santander.cepFinder.dto.response.CepResponseDTO;
import com.santander.cepFinder.integration.ApiConnectionException;

public class CepTransformer {

    private final ObjectMapper objectMapper;

    public CepTransformer() {
        this.objectMapper = new ObjectMapper();
    }

    public CepResponseDTO transform(ConecctionApi conn) throws ApiConnectionException {

        try {
            return objectMapper.readValue(conn.getJson(), CepResponseDTO.class);
        } catch (Exception e) {
            throw new ApiConnectionException("Erro ao analisar a resposta JSON para o CepResponseDTO", e);
        }
    }
}
