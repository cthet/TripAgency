package com.kata.tripagency.infrastructure.repository.springdatajpa.Adapters;

import com.kata.tripagency.domain.exception.TripNotFoundException;
import com.kata.tripagency.domain.model.TicketFees;
import com.kata.tripagency.domain.port.repositories.TicketFeesRepositoryPort;
import com.kata.tripagency.domain.util.ErrorMessages;
import com.kata.tripagency.infrastructure.repository.springdatajpa.Entity.TicketFeesEntity;
import com.kata.tripagency.infrastructure.repository.springdatajpa.Repository.TicketFeesJpaRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("TicketFeesRepositoryJpaAdapter")
public class TicketFeesJpaRepositoryPortJpaAdapter implements TicketFeesRepositoryPort {

    private TicketFeesJpaRepository ticketFeesJpaRepository;

    public TicketFeesJpaRepositoryPortJpaAdapter(TicketFeesJpaRepository ticketFeesJpaRepository) {
        this.ticketFeesJpaRepository = ticketFeesJpaRepository;
    }


    @Override
    public TicketFees byTripId(Long id) {
        TicketFeesEntity ticketFeesEntity = ticketFeesJpaRepository.findByTripId(id)
                .orElseThrow(() -> new TripNotFoundException(ErrorMessages.TICKET_FEES_NOT_FOUND));

        return ticketFeesEntity.convertToTicketFees();
    }
}
