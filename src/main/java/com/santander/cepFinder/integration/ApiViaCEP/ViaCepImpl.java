package com.santander.cepFinder.integration.ApiViaCEP;

import com.santander.cepFinder.dto.response.CepResponseDTO;
import com.santander.cepFinder.integration.ApiConnectionException;
import com.santander.cepFinder.integration.CepDetailsNotAvailableException;
import com.santander.cepFinder.integration.CepNotFoundException;
import com.santander.cepFinder.integration.ExternalCepServiceClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;


@Component
@Qualifier("viaCep")
public class ViaCepImpl implements ExternalCepServiceClient {

    @Override
    public CepResponseDTO getDetails(String zipCode) throws ApiConnectionException, CepNotFoundException, CepDetailsNotAvailableException {
        ConecctionApi conn = new ConecctionApi(zipCode);
        CepResponseDTO response = new CepTransformer().transform(conn);
        validateAddress(response, zipCode);
        return response;
    }


    public void validateAddress(CepResponseDTO response, String zipCode) throws CepDetailsNotAvailableException  {
        if (!response.addressValid()) {
            throw new CepDetailsNotAvailableException("Não encontrado informações para esse CEP: " + zipCode, HttpStatus.NOT_FOUND.value());
        }
    }
}
