package com.santander.cepFinder.service;

import com.santander.cepFinder.dto.response.FrequentlyConsultedCepDTO;
import com.santander.cepFinder.dto.response.FrequentlyConsultedStateDTO;
import com.santander.cepFinder.filter.stats.AggregatedCepStateFilter;
import com.santander.cepFinder.filter.stats.CepStatsFilter;

import java.util.List;

public interface CepStatsService {
    List<FrequentlyConsultedCepDTO> getMostFrequentlyConsultedCeps(CepStatsFilter filter);

    List<FrequentlyConsultedStateDTO> getStateCepAllocationStats(AggregatedCepStateFilter filter);
}
