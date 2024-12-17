package com.santander.cepFinder.service.impl;

import com.santander.cepFinder.dto.response.FrequentlyConsultedCepDTO;
import com.santander.cepFinder.dto.response.FrequentlyConsultedStateDTO;
import com.santander.cepFinder.dto.filters.stats.AggregatedCepStateFilter;
import com.santander.cepFinder.dto.filters.stats.CepStatsFilter;
import com.santander.cepFinder.repository.CepStatsRepository;
import com.santander.cepFinder.service.CepStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CepStatsServiceImpl implements CepStatsService {

    private final CepStatsRepository cepStatsRepository;

    @Autowired
    public CepStatsServiceImpl(CepStatsRepository cepStatsRepository) {
        this.cepStatsRepository = cepStatsRepository;
    }

    @Override
    public List<FrequentlyConsultedCepDTO> getMostFrequentlyConsultedCeps(CepStatsFilter filter) {
        return cepStatsRepository.findMostFrequentlyConsultedCeps(filter);
    }

    @Override
    public List<FrequentlyConsultedStateDTO> getStateCepAllocationStats(AggregatedCepStateFilter filter) {
        return cepStatsRepository.findStateCepAllocationStats(filter);
    }
}