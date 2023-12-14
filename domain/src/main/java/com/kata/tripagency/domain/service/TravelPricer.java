package com.kata.tripagency.domain.service;

import com.kata.tripagency.domain.exception.InvalidDepartureException;
import com.kata.tripagency.domain.exception.InvalidDestinationException;
import com.kata.tripagency.domain.model.TicketFees;
import com.kata.tripagency.domain.model.Trip;
import com.kata.tripagency.domain.port.drivers.PriceComputorDriverPort;
import com.kata.tripagency.domain.port.repositories.TicketFeesRepositoryPort;
import com.kata.tripagency.domain.port.repositories.TripRepositoryPort;
import com.kata.tripagency.domain.util.ErrorMessages;

import java.math.BigDecimal;

public class TravelPricer implements PriceComputorDriverPort {
    protected TicketFeesRepositoryPort ticketFeesRepository;
    protected TripRepositoryPort tripRepository;

    public TravelPricer() {
    }

    public TravelPricer(TicketFeesRepositoryPort ticketFeesRepository, TripRepositoryPort tripRepositoryPort) {
        this.ticketFeesRepository = ticketFeesRepository;
        this.tripRepository = tripRepositoryPort;
    }

    @Override
    public BigDecimal priceTrip(String departure, String destination) {
        checkDeparture(departure);
        checkDestination(destination);
        Trip trip = tripRepository.findByDepartureAndDestination(departure, destination);

        return computePriceTicket(trip);
    }

    private BigDecimal computePriceTicket(Trip trip) {
        TicketFees ticketFees = ticketFeesRepository.byTripId(trip.getId());
        return trip.getTicketPrice().add(ticketFees.getAgencyFees()).add(ticketFees.getTravelFees());
    }

    private void checkDeparture(String departure) {
        if (departure == null)
            throw new InvalidDepartureException(ErrorMessages.DEPARTURE_REQUIRED);
    }
    private void checkDestination(String destination) {
        if (destination ==null)
            throw new InvalidDestinationException(ErrorMessages.DESTINATION_REQUIRED);
    }


}
