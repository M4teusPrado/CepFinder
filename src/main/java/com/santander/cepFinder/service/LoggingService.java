package com.santander.cepFinder.service;

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

    public void logConsultaCep(String cep, String response) {
        CepLog cepLog = new CepLog();
        cepLog.setCep(cep);
        cepLog.setResponse(response);
        cepLog.setQueryTime(LocalDateTime.now());

        cepLogRepository.save(cepLog);
    }
}
