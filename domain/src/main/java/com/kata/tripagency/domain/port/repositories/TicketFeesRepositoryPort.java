package com.kata.tripagency.domain.port.repositories;

import com.kata.tripagency.domain.model.TicketFees;

public interface TicketFeesRepositoryPort {

    TicketFees byTripId(Long id);

}
