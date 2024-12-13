package com.santander.cepFinder.service;

import com.santander.cepFinder.dto.request.CepRequestDTO;
import com.santander.cepFinder.dto.response.CepResponseDTO;
import com.santander.cepFinder.integration.ApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class SearchCepServiceImpl implements SearchCepService {

    private final ApiClient apiClient;

    @Autowired
    public SearchCepServiceImpl(@Qualifier("viaCep") ApiClient cepApiClient) {
        this.apiClient = cepApiClient;
    }

    // Preciso me conectar com outra API (https://viacep.com.br/)

    // Verificar se a conexão teve sucesso

    // Se não tratar a ex

    // Verificar se o CEP foi encontrado

    // Caso seja retornar o CEP com um DTO

    // Caso não retornar uma menssagem indicativa

    @Override
    public CepResponseDTO getCepDetails(CepRequestDTO cepDto) {
        String cep = cepDto.getCep();
        CepResponseDTO cepResponse = apiClient.getCep(cep);
        System.out.println(cepResponse.getCep());
        return cepResponse;
    }
}
