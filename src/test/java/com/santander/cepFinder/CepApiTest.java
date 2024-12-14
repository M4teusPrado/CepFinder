package com.santander.cepFinder;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.santander.cepFinder.integration.ApiViaCEP.ConecctionApi;
import org.junit.jupiter.api.BeforeEach;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class CepApiTest {

//    @BeforeEach
//    public void setup() {
//        WireMock.configureFor("localhost", 8080);
//        WireMock.stubFor(get(urlEqualTo("/ws/01001000/json/"))
//                .willReturn(aResponse()
//                        .withHeader("Content-Type", "application/json")
//                        .withStatus(200)
//                        .withBody("{ \"cep\": \"01001-000\", \"logradouro\": \"Praça da Sé\", \"bairro\": \"Sé\", \"localidade\": \"São Paulo\", \"uf\": \"SP\" }")));
//    }
//
//    @Test
//    public void testBuscarCep() throws Exception {
//        ConecctionApi conecctionApi = new ConecctionApi("01001000");
//
//        // Verifica se a resposta da API mockada está correta
//        assert conecctionApi.getJson().contains("01001-000");
//    }
}
