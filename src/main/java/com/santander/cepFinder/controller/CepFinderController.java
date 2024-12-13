package com.santander.cepFinder.controller;

import com.santander.cepFinder.dto.request.CepRequestDTO;
import com.santander.cepFinder.dto.response.CepResponseDTO;
import com.santander.cepFinder.service.SearchCepService;
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

    @Autowired
    public CepFinderController(SearchCepService cepService) {
        this.cepService = cepService;
    }

    @PostMapping
    private ResponseEntity<CepResponseDTO> searchCep(@RequestBody CepRequestDTO cepRequestDTO) {
        CepResponseDTO cepResponseDto = cepService.getCepDetails(cepRequestDTO);
        return ResponseEntity.ok(cepResponseDto);
    }
}
