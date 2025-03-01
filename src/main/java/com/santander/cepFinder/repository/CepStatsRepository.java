package com.santander.cepFinder.repository;

import com.santander.cepFinder.dto.filters.stats.AggregatedCepCityFilter;
import com.santander.cepFinder.dto.response.FrequentlyConsultedCepDTO;
import com.santander.cepFinder.dto.response.FrequentlyConsultedCityDTO;
import com.santander.cepFinder.dto.response.FrequentlyConsultedStateDTO;
import com.santander.cepFinder.dto.filters.stats.AggregatedCepStateFilter;
import com.santander.cepFinder.dto.filters.stats.CepStatsFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CepStatsRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public CepStatsRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<FrequentlyConsultedCepDTO> findMostFrequentlyConsultedCeps(CepStatsFilter filter) {


        StringBuilder sql = new StringBuilder();
        sql.append("SELECT c.cep, COUNT(c.cep) AS total_consultas ")
                .append("FROM CEP_LOGS c ")
                .append("WHERE 1=1 ");

        MapSqlParameterSource params = new MapSqlParameterSource();

        if (filter.getCity() != null) {
            sql.append("AND UPPER(c.cidade) = :cidade ");
            params.addValue("cidade", filter.getCity().toUpperCase());
        }

        if (filter.getState() != null) {
            sql.append("AND UPPER(c.estado) = :estado ");
            params.addValue("estado", filter.getState().toUpperCase());
        }

        if (filter.getStartDate() != null) {
            sql.append("AND c.query_time >= :startDate ");
            params.addValue("startDate", filter.getStartDateTime());
        }
        if (filter.getEndDate() != null) {
            sql.append("AND c.query_time <= :endDate ");
            params.addValue("endDate", filter.getEndDateTime());
        }

        sql.append("GROUP BY c.cep ")
                .append("ORDER BY total_consultas DESC");

        if (filter.getLimit() != 0) {
            sql.append(" LIMIT :limit ");
            params.addValue("limit", filter.getLimit());
        }

        return jdbcTemplate.query(sql.toString(), params, (rs, rowNum) ->
                new FrequentlyConsultedCepDTO(rs.getString("cep"), rs.getLong("total_consultas"))
        );
    }


    public List<FrequentlyConsultedStateDTO> findStateCepAllocationStats(AggregatedCepStateFilter filter) {

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT c.estado, COUNT(c.cep) AS total_ceps ")
                .append("FROM CEP_LOGS c ")
                .append("WHERE 1=1 ");

        MapSqlParameterSource params = new MapSqlParameterSource();

        if (filter.getStartDate() != null) {
            sql.append("AND c.query_time >= :startDate ");
            params.addValue("startDate", filter.getStartDateTime());
        }

        if (filter.getEndDate() != null) {
            sql.append("AND c.query_time <= :endDate ");
            params.addValue("endDate", filter.getEndDateTime());
        }

        sql.append("GROUP BY c.estado ")
                .append("ORDER BY total_ceps DESC");

        if (filter.getLimit() != 0) {
            sql.append(" LIMIT :limit ");
            params.addValue("limit", filter.getLimit());
        }

        return jdbcTemplate.query(sql.toString(), params, (rs, rowNum) ->
                new FrequentlyConsultedStateDTO(rs.getString("estado"), rs.getLong("total_ceps"))
        );
    }

        public List<FrequentlyConsultedCityDTO> findFrequentlyConsultedCepsByCity(AggregatedCepCityFilter filter) {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT c.cidade, COUNT(c.cep) AS total_consultas ")
                    .append("FROM CEP_LOGS c ")
                    .append("WHERE 1=1 ");

            MapSqlParameterSource params = new MapSqlParameterSource();

            // Apply filters based on provided parameters
            if (filter.getState() != null) {
                sql.append("AND UPPER(c.estado) = :estado ");
                params.addValue("estado", filter.getState().toUpperCase());
            }

            if (filter.getStartDate() != null) {
                sql.append("AND c.query_time >= :startDate ");
                params.addValue("startDate", filter.getStartDateTime());
            }

            if (filter.getEndDate() != null) {
                sql.append("AND c.query_time <= :endDate ");
                params.addValue("endDate", filter.getEndDateTime());
            }

            // Group by city and order by total consultations (DESC)
            sql.append("GROUP BY c.cidade ")
                    .append("ORDER BY total_consultas DESC");

            // Apply limit if specified
            if (filter.getLimit() != 0) {
                sql.append(" LIMIT :limit ");
                params.addValue("limit", filter.getLimit());
            }

            // Execute the query and return the result
            return jdbcTemplate.query(sql.toString(), params, (rs, rowNum) ->
                    new FrequentlyConsultedCityDTO(rs.getString("cidade"), rs.getLong("total_consultas"))
            );
        }
}