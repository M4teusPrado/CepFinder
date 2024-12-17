package com.santander.cepFinder.filter;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CepStatsFilter {

    @JsonProperty("limite")
    @Schema(description = "Limite de registros a serem retornados.", example = "10", defaultValue = "10")
    private int limit;

    @JsonProperty("dataInicial")
    @Schema(description = "Data inicial para o filtro no formato 'yyyy-MM-dd'.", example = "2024-01-01")
    private String startDate;

    @JsonProperty("dataFinal")
    @Schema(description = "Data final para o filtro no formato 'yyyy-MM-dd'.", example = "2024-01-31")
    private String endDate;

    @JsonProperty("cidade")
    @Schema(description = "Nome da cidade para o filtro.", example = "São Paulo")
    private String city;

    @JsonProperty("estado")
    @Schema(description = "Sigla do estado no formato 'XX'.", example = "SP")
    private String state;
}