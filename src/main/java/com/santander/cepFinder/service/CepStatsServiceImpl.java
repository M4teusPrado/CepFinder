package com.santander.cepFinder.service;

import com.santander.cepFinder.dto.response.FrequentlyConsultedCepDTO;
import com.santander.cepFinder.filter.CepStatsFilter;
import com.santander.cepFinder.repository.CepStatsRepository;
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
}