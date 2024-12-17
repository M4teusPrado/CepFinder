package com.santander.cepFinder.controller;

import com.santander.cepFinder.dto.response.FrequentlyConsultedCepDTO;
import com.santander.cepFinder.filter.CepStatsFilter;
import com.santander.cepFinder.service.CepStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ceps/stats")
public class CepStatsController {

    private final CepStatsService statsService;

    @Autowired
    public CepStatsController(CepStatsService statsService) {
        this.statsService = statsService;
    }

    @GetMapping("/ranking")
    public ResponseEntity<List<FrequentlyConsultedCepDTO>> getTopConsultedCeps(
            @RequestParam(value = "limite", required = false, defaultValue = "10") int limit,
            @RequestParam(value = "dataInicial", required = false) String startDate,
            @RequestParam(value = "dataFinal", required = false) String endDate,
            @RequestParam(value = "cidade", required = false) String city,
            @RequestParam(value = "estado", required = false) String state) {

        // Criação do objeto CepStatsFilter e configuração dos campos
        CepStatsFilter filter = new CepStatsFilter();
        filter.setLimit(limit);
        filter.setStartDate(startDate);
        filter.setEndDate(endDate);
        filter.setCity(city);
        filter.setState(state);

        // Obtém o ranking com base no filtro
        List<FrequentlyConsultedCepDTO> topCeps = statsService.getMostFrequentlyConsultedCeps(filter);
        return ResponseEntity.ok(topCeps);
    }
}
