package com.santander.cepFinder.service;

import com.santander.cepFinder.dto.response.FrequentlyConsultedCepDTO;
import com.santander.cepFinder.filter.CepStatsFilter;

import java.util.List;

public interface CepStatsService {
    List<FrequentlyConsultedCepDTO> getMostFrequentlyConsultedCeps(CepStatsFilter filter);
}
