package com.santander.cepFinder.dto.request;

import lombok.Data;

@Data
public class CepRequestDTO {

    //TODO: Implementar validação
    private String cep;

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
