package com.kata.tripagency.infrastructure.repository.springdatajpa.Adapters;

import com.kata.tripagency.domain.exception.TripNotFoundException;
import com.kata.tripagency.domain.model.Trip;
import com.kata.tripagency.domain.port.repositories.TripRepositoryPort;
import com.kata.tripagency.domain.util.ErrorMessages;
import com.kata.tripagency.infrastructure.repository.springdatajpa.Entity.TripEntity;
import com.kata.tripagency.infrastructure.repository.springdatajpa.Repository.TripJpaRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("TripRepositoryJpaAdapter")
public class TripRepositoryPortJpaAdapter implements TripRepositoryPort {
    
    private TripJpaRepository tripJpaRepository;

    public TripRepositoryPortJpaAdapter(TripJpaRepository tripJpaRepository) {
        this.tripJpaRepository = tripJpaRepository;
    }

    @Override
    public Trip findByDepartureAndDestination(String departure, String destination) {

        TripEntity tripEntity = tripJpaRepository.findByDepartureAndDestination(departure, destination)
                   .orElseThrow(() -> new TripNotFoundException(ErrorMessages.TRIP_NOT_FOUND));

        return tripEntity.convertToTrip();
    }

}
