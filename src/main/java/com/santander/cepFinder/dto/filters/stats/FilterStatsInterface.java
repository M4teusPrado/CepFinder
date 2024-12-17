package com.santander.cepFinder.dto.filters.stats;

import java.time.LocalDateTime;

public interface FilterStatsInterface {

    LocalDateTime getStartDateTime();

    LocalDateTime getEndDateTime();
}
