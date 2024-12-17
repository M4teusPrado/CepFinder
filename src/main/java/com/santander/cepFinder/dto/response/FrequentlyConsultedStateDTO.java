package com.santander.cepFinder.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FrequentlyConsultedStateDTO {

    @JsonProperty("estado")
    private String state;

    @JsonProperty("totalConsultas")
    private long totalQueries;
}
