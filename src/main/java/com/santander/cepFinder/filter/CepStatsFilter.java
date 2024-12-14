package com.santander.cepFinder.filter;

import lombok.Data;

@Data
public class CepStatsFilter {

    private int limit;
    private String startDate;
    private String endDate;
    private String city;
    private String state;


    public CepStatsFilter(int limit, String startDate, String endDate, String city, String state) {
        this.limit = limit;
        this.startDate = startDate;
        this.endDate = endDate;
        this.city = city;
        this.state = state;
    }
}
