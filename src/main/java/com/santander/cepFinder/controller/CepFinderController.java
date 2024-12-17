package com.santander.cepFinder.controller;

import com.santander.cepFinder.dto.request.CepRequestDTO;
import com.santander.cepFinder.dto.response.CepResponseDTO;
import com.santander.cepFinder.dto.response.error.base.ErrorResponse;
import com.santander.cepFinder.dto.response.error.base.ErrorSearchCep;
import com.santander.cepFinder.service.LoggingService;
import com.santander.cepFinder.service.SearchCepService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.base.url}")
public class CepFinderController {

    private final SearchCepService cepService;
    private final LoggingService loggingService;

    @Autowired
    public CepFinderController(SearchCepService cepService, LoggingService loggingService) {
        this.cepService = cepService;
        this.loggingService = loggingService;
    }

    @PostMapping("/buscar")
    @Operation(
            summary = "Buscar detalhes de um CEP",
            description = "Realiza a busca de informações detalhadas de um CEP informado."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Detalhes do CEP encontrados com sucesso.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CepResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Requisição inválida, o formato do CEP pode estar errado.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Erro interno ao buscar o CEP.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    private ResponseEntity<CepResponseDTO> searchCep(@RequestBody @Valid CepRequestDTO cepRequestDTO) throws ErrorSearchCep {
        CepResponseDTO cepResponseDto = cepService.getCepDetails(cepRequestDTO);
        loggingService.logConsultaCep(cepResponseDto);
        return ResponseEntity.ok(cepResponseDto);
    }
}