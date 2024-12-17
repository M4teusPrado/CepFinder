package com.santander.cepFinder.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FrequentlyConsultedCityDTO {

    @JsonProperty("cidade")
    private String city;

    @JsonProperty("totalConsultas")
    private long totalQueries;


    public FrequentlyConsultedCityDTO(String city, long totalQueries) {
        this.city = city;
        this.totalQueries = totalQueries;
    }
}
