package com.santander.cepFinder.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CepRequestDTO {

    @NotNull
    @Pattern(
            regexp = "^[0-9]{8}$|^[0-9]{5}-[0-9]{3}$",
            message = "CEP inválido. O formato deve ser '12345678' ou '12345-678'."
    )
    @Schema(
            description = "CEP: deve estar no formato '12345678' ou '12345-678'.",
            example = "18117140"
    )
    @JsonProperty("cep")
    private String zipCode;



    public String getZipCode() {
        return this.zipCode.replace("-" , "");
    }
}
