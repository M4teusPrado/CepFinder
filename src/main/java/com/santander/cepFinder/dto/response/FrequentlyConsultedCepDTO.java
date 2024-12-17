package com.santander.cepFinder.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FrequentlyConsultedCepDTO {

    @JsonProperty("cep")
    private String zipCode;

    @JsonProperty("totalConsultas")
    private long totalQueries;

    public FrequentlyConsultedCepDTO(String zipCode, long totalQueries) {
        this.zipCode = zipCode;
        this.totalQueries = totalQueries;
    }
}
