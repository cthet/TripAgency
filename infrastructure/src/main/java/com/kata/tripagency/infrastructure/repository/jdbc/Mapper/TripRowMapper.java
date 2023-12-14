package com.kata.tripagency.infrastructure.repository.jdbc.Mapper;

import com.kata.tripagency.domain.model.Trip;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TripRowMapper implements RowMapper<Trip> {


    @Override
    public Trip mapRow(ResultSet row, int rowNum) throws SQLException {
        String departure = row.getString("departure");
        String destination = row.getString("destination");

        Trip trip = new Trip();

        trip.setId(row.getLong("id"));
        trip.setDeparture(departure);
        trip.setDestination(destination);
        trip.setTicketPrice(row.getBigDecimal("ticket_price"));
        return trip;
    }
}
