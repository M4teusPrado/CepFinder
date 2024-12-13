package com.santander.cepFinder.integration.ApiViaCEP;

import com.santander.cepFinder.dto.response.CepResponseDTO;
import com.santander.cepFinder.integration.ApiConnectionException;
import com.santander.cepFinder.integration.CepNotFoundException;
import com.santander.cepFinder.integration.ExternalCepServiceClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;



@Component
@Qualifier("viaCep")
public class ViaCepImpl implements ExternalCepServiceClient {

    @Override
    public CepResponseDTO getDetails(String cep) throws ApiConnectionException, CepNotFoundException {
        ConecctionApi conn = new ConecctionApi(cep);

        return new CepTransformer().transform(conn);
    }
}
