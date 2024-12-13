package com.santander.cepFinder.service;

import com.santander.cepFinder.dto.request.CepRequestDTO;
import com.santander.cepFinder.dto.response.CepResponseDTO;

public interface SearchCepService {
    CepResponseDTO getCepDetails(CepRequestDTO cep);
}
