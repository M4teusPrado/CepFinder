package com.santander.cepFinder.service.impl;

import com.santander.cepFinder.dto.request.CepRequestDTO;
import com.santander.cepFinder.dto.response.CepResponseDTO;
import com.santander.cepFinder.dto.response.error.ErrorApiConnection;
import com.santander.cepFinder.dto.response.error.ErrorCepNotFound;
import com.santander.cepFinder.dto.response.error.base.ErrorSearchCep;
import com.santander.cepFinder.integration.ApiConnectionException;
import com.santander.cepFinder.integration.CepNotFoundException;
import com.santander.cepFinder.integration.ExternalCepServiceClient;
import com.santander.cepFinder.service.SearchCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class SearchCepServiceImpl implements SearchCepService {

    private final ExternalCepServiceClient externalCepServiceClient;

    @Autowired
    public SearchCepServiceImpl(@Qualifier("viaCep") ExternalCepServiceClient externalCepServiceClient) {
        this.externalCepServiceClient = externalCepServiceClient;
    }

    @Override
    public CepResponseDTO getCepDetails(CepRequestDTO dto) throws ErrorSearchCep {
        try {
            return externalCepServiceClient.getDetails(dto.getZipCode());
        } catch (ApiConnectionException e) {
            throw new ErrorApiConnection(e);
        } catch (CepNotFoundException e) {
            throw new ErrorCepNotFound(e);
        }
    }
}
