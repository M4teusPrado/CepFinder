package com.santander.cepFinder.filter;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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


    public LocalDateTime getStartDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
        return LocalDateTime.parse(startDate + " 00:00:00.000000", formatter); // Assume início do dia
    }

    public LocalDateTime getEndDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
        return LocalDateTime.parse(endDate + " 23:59:59.999999", formatter); // Assume fim do dia
    }
}