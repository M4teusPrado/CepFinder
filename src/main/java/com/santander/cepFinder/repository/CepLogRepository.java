package com.santander.cepFinder.repository;

import com.santander.cepFinder.entity.modal.CepLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CepLogRepository extends JpaRepository<CepLog, Long> {

}