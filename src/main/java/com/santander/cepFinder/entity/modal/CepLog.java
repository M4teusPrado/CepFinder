package com.santander.cepFinder.entity.modal;

import com.santander.cepFinder.dto.response.CepResponseDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cep_logs")
public class CepLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cep")
    private String zipCode;

    @Column(name = "cidade")
    private String city;

    @Column(name = "estado")
    private String state;

    @Column(name = "response")
    private String response;

    @Column(name = "query_time")
    private LocalDateTime queryTime;

    public CepLog(CepResponseDTO response) {
        this.zipCode = response.getZipCode();
        this.city = response.getCity();
        this.state = response.getState();
        this.queryTime = LocalDateTime.now();
        this.response = response.toString();
    }
}
