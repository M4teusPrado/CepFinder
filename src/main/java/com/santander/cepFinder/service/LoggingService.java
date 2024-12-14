package com.santander.cepFinder.service;

import com.santander.cepFinder.dto.response.CepResponseDTO;
import com.santander.cepFinder.entity.modal.CepLog;
import com.santander.cepFinder.repository.CepLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LoggingService {

    private final CepLogRepository cepLogRepository;

    @Autowired
    public LoggingService(CepLogRepository cepLogRepository) {
        this.cepLogRepository = cepLogRepository;
    }

    public void logConsultaCep(CepResponseDTO response) {
        CepLog cepLog = new CepLog();
        cepLog.setCep(response.getCep());
        cepLog.setCidade(response.getCidade());
        cepLog.setEstado(response.getEstado());
        cepLog.setResponse(response.toString());
        cepLog.setQueryTime(LocalDateTime.now());

        cepLogRepository.save(cepLog);
    }
}
