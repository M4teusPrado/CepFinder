package com.santander.cepFinder.controller;

import com.santander.cepFinder.dto.request.CepRequestDTO;
import com.santander.cepFinder.dto.response.CepResponseDTO;
import com.santander.cepFinder.dto.response.error.base.ErrorSearchCep;
import com.santander.cepFinder.service.LoggingService;
import com.santander.cepFinder.service.SearchCepService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ceps")
public class CepFinderController {

    private final SearchCepService cepService;
    private final LoggingService loggingService;

    @Autowired
    public CepFinderController(SearchCepService cepService, LoggingService loggingService) {
        this.cepService = cepService;
        this.loggingService = loggingService;
    }

    @PostMapping
    private ResponseEntity<CepResponseDTO> searchCep(@RequestBody @Valid CepRequestDTO cepRequestDTO) throws ErrorSearchCep {
        CepResponseDTO cepResponseDto = cepService.getCepDetails(cepRequestDTO);
        loggingService.logConsultaCep(cepResponseDto);
        return ResponseEntity.ok(cepResponseDto);
    }
}