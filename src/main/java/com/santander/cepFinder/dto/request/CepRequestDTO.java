package com.santander.cepFinder.dto.request;

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
    private String cep;



    public String getCep() {
        return cep.replace("-" , "");
    }
}
