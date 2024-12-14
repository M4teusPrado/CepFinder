package com.santander.cepFinder.entity.modal;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cep_logs")
public class CepLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cep")
    private String cep;

    @Column(name = "response")
    private String response;

    @Column(name = "query_time")
    private LocalDateTime queryTime;

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public void setQueryTime(LocalDateTime queryTime) {
        this.queryTime = queryTime;
    }
}
