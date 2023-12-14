package com.kata.tripagency.infrastructure.repository.springdatajpa.Repository;

import com.kata.tripagency.infrastructure.repository.springdatajpa.Entity.TripEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TripJpaRepository extends JpaRepository<TripEntity, Long> {

    @Query("SELECT trip FROM TripEntity trip WHERE  LOWER(trip.destination) = LOWER(:destination) AND  LOWER(trip.departure) = LOWER(:departure)")
    Optional<TripEntity> findByDepartureAndDestination(@Param("departure") String departure,
                                                       @Param("destination") String destination);

}
