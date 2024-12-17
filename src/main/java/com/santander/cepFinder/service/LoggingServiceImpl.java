package com.santander.cepFinder.service;

import com.santander.cepFinder.dto.response.CepResponseDTO;
import com.santander.cepFinder.entity.modal.CepLog;
import com.santander.cepFinder.repository.CepLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoggingServiceImpl implements LoggingService {

    private final CepLogRepository cepLogRepository;

    @Autowired
    public LoggingServiceImpl(CepLogRepository cepLogRepository) {
        this.cepLogRepository = cepLogRepository;
    }

    public void logConsultaCep(CepResponseDTO response) {
        cepLogRepository.save(new CepLog(response));
    }
}
