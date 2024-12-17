package com.santander.cepFinder.filter.stats;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CepStatsFilter extends BaseFilterStats {

    @JsonProperty("cidade")
    @Schema(description = "Nome da cidade para o filtro.", example = "São Paulo")
    private String city;

    @JsonProperty("estado")
    @Schema(description = "Sigla do estado no formato 'XX'.", example = "SP")
    private String state;
}