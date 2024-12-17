package com.santander.cepFinder.repository;

import com.santander.cepFinder.dto.response.FrequentlyConsultedCepDTO;
import com.santander.cepFinder.filter.CepStatsFilter;
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
            sql.append("AND c.cidade = :cidade ");
            params.addValue("cidade", filter.getCity());
        }
        if (filter.getState() != null) {
            sql.append("AND c.estado = :estado ");
            params.addValue("estado", filter.getState());
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


}
