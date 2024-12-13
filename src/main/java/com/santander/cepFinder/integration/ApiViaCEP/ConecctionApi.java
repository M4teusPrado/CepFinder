package com.santander.cepFinder.integration.ApiViaCEP;

import com.santander.cepFinder.integration.ApiConnectionException;
import com.santander.cepFinder.integration.CepNotFoundException;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConecctionApi {


    private final String json;
    private final boolean success;
    Integer statusCode;
    private static final String URL_VIACEP = "https://viacep.com.br/ws/";

    public ConecctionApi(String cep) throws ApiConnectionException, CepNotFoundException {
        try {
            HttpRequest request = HttpRequest.newBuilder().uri(buildURI(cep)).build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

            statusCode = response.statusCode();
            success = statusCode == HttpStatus.OK.value();
            json = response.body();

            if (!isSuccess()) {
                throw new CepNotFoundException("Falha ao buscar detalhes do CEP: '" + cep + "'" , statusCode );
            }

        } catch (InterruptedException | IOException e) {
            throw new ApiConnectionException("Ocorreu um erro de conexão com a API", e);
        } catch (URISyntaxException e) {
            throw new ApiConnectionException("Sintaxe da URI inválida", e);
        }
    }

    public static URI buildURI(String cep) throws MalformedURLException, URISyntaxException {
        return new URL(URL_VIACEP + cep + "/json/").toURI();
    }

    boolean isSuccess(){
        return success;
    }

    public String getJson() {
        return json;
    }
}
