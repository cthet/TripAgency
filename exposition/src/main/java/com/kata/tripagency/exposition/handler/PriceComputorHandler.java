package com.kata.tripagency.exposition.handler;

import com.kata.tripagency.domain.port.repositories.TicketFeesRepositoryPort;
import com.kata.tripagency.domain.port.repositories.TripRepositoryPort;
import com.kata.tripagency.domain.service.TravelPricer;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PriceComputorHandler extends TravelPricer {
    private final PriceComputorRepositoryManager priceComputorRepositoryManager;

    public PriceComputorHandler(PriceComputorRepositoryManager priceComputorRepositoryManager){
        this.priceComputorRepositoryManager = priceComputorRepositoryManager;
    }

    private void setTripRepository(TripRepositoryPort tripRepository) {
        this.tripRepository = tripRepository;
    }

    private void setTicketFeesRepository(TicketFeesRepositoryPort ticketFeesRepository) {
        this.ticketFeesRepository = ticketFeesRepository;
    }

    public BigDecimal priceTravel(String departure, String destination, RepositoryType repositoryType) {
        TripRepositoryPort tripRepositoryAdapter = priceComputorRepositoryManager.getTripRepositoryAdapter(repositoryType);
        TicketFeesRepositoryPort ticketFeesRepositoryPort = priceComputorRepositoryManager.getTicketFeesRepositoryPort(repositoryType);

        this.setTripRepository(tripRepositoryAdapter);
        this.setTicketFeesRepository(ticketFeesRepositoryPort);

        return super.priceTrip(departure, destination);
    }
}
