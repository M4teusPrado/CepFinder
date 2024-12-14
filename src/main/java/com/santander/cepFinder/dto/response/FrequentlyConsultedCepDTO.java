package com.santander.cepFinder.dto.response;

import lombok.Data;

@Data
public class FrequentlyConsultedCepDTO {
    private String cep;
    private long totalConsultas;

    public FrequentlyConsultedCepDTO(String cep, long totalConsultas) {
        this.cep = cep;
        this.totalConsultas = totalConsultas;
    }
}
