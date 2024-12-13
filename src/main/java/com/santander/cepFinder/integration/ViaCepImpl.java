package com.santander.cepFinder.integration;

import com.santander.cepFinder.dto.response.CepResponseDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Qualifier("viaCep")
public class ViaCepImpl implements ApiClient {

    //private static final String VIACEP_URL = "https://viacep.com.br/ws/%s/json/";

    @Override
    public CepResponseDTO getCep(String cep) {
        CepResponseDTO teste = new CepResponseDTO();
        teste.setCep("18117140");
        return teste;
    }
}
