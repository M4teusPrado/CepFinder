package com.santander.cepFinder.controller;

import com.santander.cepFinder.dto.response.FrequentlyConsultedCepDTO;
import com.santander.cepFinder.filter.CepStatsFilter;
import com.santander.cepFinder.service.CepStatsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<FrequentlyConsultedCepDTO>> getTopConsultedCeps(@Valid @ModelAttribute CepStatsFilter filter) {
        List<FrequentlyConsultedCepDTO> topCeps = statsService.getMostFrequentlyConsultedCeps(filter);
        return ResponseEntity.ok(topCeps);
    }
}
