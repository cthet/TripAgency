package com.kata.tripagency.domain.port.repositories;

import com.kata.tripagency.domain.model.Trip;

public interface TripRepositoryPort {

    Trip findByDepartureAndDestination(String departure, String destination);

}
