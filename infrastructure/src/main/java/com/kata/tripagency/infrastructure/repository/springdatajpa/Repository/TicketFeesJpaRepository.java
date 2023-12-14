package com.kata.tripagency.infrastructure.repository.springdatajpa.Repository;

import com.kata.tripagency.infrastructure.repository.springdatajpa.Entity.TicketFeesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TicketFeesJpaRepository extends JpaRepository<TicketFeesEntity, Long> {

    @Query("SELECT ticketFees FROM TicketFeesEntity ticketFees WHERE  ticketFees.tripEntity.id = :TripId")
    Optional<TicketFeesEntity> findByTripId(@Param("TripId") Long TripId);
}
