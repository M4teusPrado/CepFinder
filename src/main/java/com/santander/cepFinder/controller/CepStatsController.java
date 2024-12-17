package com.santander.cepFinder.controller;

import com.santander.cepFinder.dto.response.FrequentlyConsultedCepDTO;
import com.santander.cepFinder.dto.response.FrequentlyConsultedStateDTO;
import com.santander.cepFinder.filter.stats.AggregatedCepStateFilter;
import com.santander.cepFinder.filter.stats.CepStatsFilter;
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

        CepStatsFilter filter = new CepStatsFilter();
        filter.setLimit(limit);
        filter.setStartDate(startDate);
        filter.setEndDate(endDate);
        filter.setCity(city);
        filter.setState(state);

        List<FrequentlyConsultedCepDTO> topCeps = statsService.getMostFrequentlyConsultedCeps(filter);
        return ResponseEntity.ok(topCeps);
    }

    @GetMapping("/ranking/estados")
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

}
