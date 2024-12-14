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
            @RequestParam(defaultValue = "10") int limit,
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String endDate,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String state) {

        CepStatsFilter filter = new CepStatsFilter(limit, startDate, endDate, city, state);
        List<FrequentlyConsultedCepDTO> topCeps = statsService.getMostFrequentlyConsultedCeps(filter);
        return ResponseEntity.ok(topCeps);
    }
}
