package com.kata.tripagency.infrastructure.repository.jdbc.Adapters;

import com.kata.tripagency.domain.model.Trip;
import com.kata.tripagency.domain.port.repositories.TripRepositoryPort;
import com.kata.tripagency.infrastructure.repository.jdbc.Mapper.TripRowMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("TripRepositoryJdbcTemplateAdapter")
public class TripRepositoryJdbcTemplateAdapter implements TripRepositoryPort {

    private JdbcTemplate jdbcTemplate;

    public TripRepositoryJdbcTemplateAdapter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public Trip findByDepartureAndDestination(String departure, String destination) {
        String sql = "SELECT destination, departure, agency_fees, stay_fees, ticket_price FROM trip WHERE LOWER(destination) = LOWER(?)";
        RowMapper<Trip> rowMapper = new TripRowMapper();

        return jdbcTemplate.queryForObject(sql, rowMapper, departure, destination);
    }
}
