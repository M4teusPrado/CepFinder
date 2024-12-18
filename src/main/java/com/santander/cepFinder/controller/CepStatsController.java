package com.santander.cepFinder.controller;

import com.santander.cepFinder.dto.filters.stats.AggregatedCepCityFilter;
import com.santander.cepFinder.dto.response.FrequentlyConsultedCepDTO;
import com.santander.cepFinder.dto.response.FrequentlyConsultedCityDTO;
import com.santander.cepFinder.dto.response.FrequentlyConsultedStateDTO;
import com.santander.cepFinder.dto.filters.stats.AggregatedCepStateFilter;
import com.santander.cepFinder.dto.filters.stats.CepStatsFilter;
import com.santander.cepFinder.dto.response.error.base.ErrorResponse;
import com.santander.cepFinder.service.CepStatsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("${api.base.url}/estatisticas")
public class CepStatsController {

    private final CepStatsService statsService;

    @Autowired
    public CepStatsController(CepStatsService statsService) {
        this.statsService = statsService;
    }

    @GetMapping("/ceps-mais-consultados")
    @Operation(
            summary = "Obter os CEPs mais consultados",
            description = "Retorna a lista de CEPs mais consultados com base no filtro de parâmetros fornecidos."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de CEPs mais consultados retornada com sucesso.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = FrequentlyConsultedCepDTO.class))),
            @ApiResponse(responseCode = "400", description = "Requisição inválida, parâmetros incorretos.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Erro interno ao buscar os CEPs mais consultados.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    public ResponseEntity<List<FrequentlyConsultedCepDTO>> getTopConsultedCeps(
            @RequestParam(value = "limite", required = false, defaultValue = "10") int limit,
            @RequestParam(value = "dataInicial", required = false) String startDate,
            @RequestParam(value = "dataFinal", required = false) String endDate,
            @RequestParam(value = "cidade", required = false) String city,
            @RequestParam(value = "estado", required = false) String state) {

        CepStatsFilter filter = new CepStatsFilter();
        filter.setLimit(limit);
        filter.setStartDate(startDate);
        filter.setEndDate(endDate);
        filter.setCity(city);
        filter.setState(state);

        List<FrequentlyConsultedCepDTO> topCeps = statsService.getMostFrequentlyConsultedCeps(filter);
        return ResponseEntity.ok(topCeps);
    }

    @GetMapping("/estados")
    @Operation(
            summary = "Obter estatísticas de alocação de CEP por estado",
            description = "Retorna as estatísticas de alocação de CEP por estado, com base no filtro de parâmetros fornecidos."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Estatísticas de alocação de CEP por estado retornadas com sucesso.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = FrequentlyConsultedStateDTO.class))),
            @ApiResponse(responseCode = "400", description = "Requisição inválida, parâmetros incorretos.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Erro interno ao buscar as estatísticas de alocação de CEP por estado.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    public ResponseEntity<List<FrequentlyConsultedStateDTO>> getStateCepAllocationStats(
            @RequestParam(value = "limite", required = false, defaultValue = "10") int limit,
            @RequestParam(value = "dataInicial", required = false) String startDate,
            @RequestParam(value = "dataFinal", required = false) String endDate) {

        AggregatedCepStateFilter filter = new AggregatedCepStateFilter();
        filter.setLimit(limit);
        filter.setStartDate(startDate);
        filter.setEndDate(endDate);

        List<FrequentlyConsultedStateDTO> stateStats = statsService.getStateCepAllocationStats(filter);
        return ResponseEntity.ok(stateStats);
    }


    @GetMapping("/cidade")
    @Operation(
            summary = "Obter os CEPs mais consultados por cidade",
            description = "Retorna a lista de CEPs mais consultados por cidade, com base no filtro de parâmetros fornecidos."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de CEPs mais consultados por cidade retornada com sucesso.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = FrequentlyConsultedCityDTO.class))),
            @ApiResponse(responseCode = "400", description = "Requisição inválida, parâmetros incorretos.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Erro interno ao buscar os CEPs mais consultados por cidade.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    public ResponseEntity<List<FrequentlyConsultedCityDTO>> getTopConsultedCepsByCity(
            @RequestParam(value = "limite", required = false, defaultValue = "10") int limit,
            @RequestParam(value = "dataInicial", required = false) String startDate,
            @RequestParam(value = "dataFinal", required = false) String endDate,
            @RequestParam(value = "estado", required = true) String state) {

        AggregatedCepCityFilter filter = new AggregatedCepCityFilter();
        filter.setLimit(limit);
        filter.setStartDate(startDate);
        filter.setEndDate(endDate);
        filter.setState(state);

        List<FrequentlyConsultedCityDTO> topCepsByCity = statsService.getMostFrequentlyConsultedCepsByCity(filter);
        return ResponseEntity.ok(topCepsByCity);
    }
}
