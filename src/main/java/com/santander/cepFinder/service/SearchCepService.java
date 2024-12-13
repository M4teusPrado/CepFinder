package com.santander.cepFinder.service;

import com.santander.cepFinder.dto.request.CepRequestDTO;
import com.santander.cepFinder.dto.response.CepResponseDTO;
import com.santander.cepFinder.dto.response.error.base.ErrorSearchCep;

public interface SearchCepService {
    CepResponseDTO getCepDetails(CepRequestDTO cep) throws ErrorSearchCep;
}
