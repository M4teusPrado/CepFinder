package com.santander.cepFinder;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CepApiTest {

    private static final String BASE_URL = "http://localhost:9090";
    private static final String MOCK_CEP_RESPONSE = "{\"cep\":\"18117-140\",\"logradouro\":\"Rua Exemplo\",\"bairro\":\"Bairro Exemplo\"," +
            "\"localidade\":\"Votorantim\",\"uf\":\"SP\",\"ibge\":\"3557003\",\"gia\":\"1075\"," +
            "\"ddd\":\"15\",\"siafi\":\"6348\"}";
    private static final String CEP_ENDPOINT = "/ws/18117140/json/";

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(9090);

    @Test
    public void testViaCepAPI() throws IOException, InterruptedException {
        configStub();


        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + CEP_ENDPOINT))
                .build();

        // Executa a requisição
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Verifica o conteúdo retornado
        String responseBody = response.body();

        // Valida o conteúdo da resposta
        assertTrue(responseBody.contains("18117-140"));
        assertTrue(responseBody.contains("Rua Exemplo"));
        assertTrue(responseBody.contains("Bairro Exemplo"));
        assertTrue(responseBody.contains("Votorantim"));
        assertTrue(responseBody.contains("SP"));
        assertTrue(responseBody.contains("3557003"));
        assertTrue(responseBody.contains("1075"));
        assertTrue(responseBody.contains("15"));
        assertTrue(responseBody.contains("6348"));
    }

    private void configStub() {
        configureFor("localhost", 9090);
        stubFor(get(urlEqualTo(CEP_ENDPOINT))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody(MOCK_CEP_RESPONSE)));
    }
}
