package com.santander.cepFinder.dto.filters.stats;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AggregatedCepCityFilter extends BaseFilterStats {

    @JsonProperty("estado")
    @Schema(description = "Sigla do estado no formato 'XX'.", example = "SP")
    private String state;

}