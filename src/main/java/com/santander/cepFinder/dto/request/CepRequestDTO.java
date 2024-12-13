package com.santander.cepFinder.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CepRequestDTO {

    @NotNull
    private String cep;
}
