package com.kata.tripagency.domain.unit;


import com.kata.tripagency.domain.model.TicketFees;
import com.kata.tripagency.domain.model.Trip;
import com.kata.tripagency.domain.port.repositories.TicketFeesRepositoryPort;
import com.kata.tripagency.domain.port.repositories.TripRepositoryPort;
import com.kata.tripagency.domain.service.TravelPricer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalculateTravelTotalPriceTest {

    public static final String NEWYORK_DESTINATION = "New-York";
    public static final String PARIS_STRING = "Paris";
    private static final Long TRIP_ID = 1L;

    private TravelPricer travelPricer;
    @Mock
    private TripRepositoryPort tripRepositoryPort;
    @Mock
    TicketFeesRepositoryPort ticketFeesRepositoryPort;

    @BeforeEach
    public void setup() {
        travelPricer = new TravelPricer(ticketFeesRepositoryPort, tripRepositoryPort);
    }

    @Test
    public void shouldManageToComputeTravelTotalPrice(){
        Trip trip = new Trip(TRIP_ID, PARIS_STRING, NEWYORK_DESTINATION, BigDecimal.valueOf(800));
        TicketFees ticketFees = new TicketFees();
        ticketFees.setTravelFees(BigDecimal.valueOf(200));
        ticketFees.setAgencyFees(BigDecimal.valueOf(50));
        ticketFees.setTripId(TRIP_ID);

        when(tripRepositoryPort.findByDepartureAndDestination(PARIS_STRING, NEWYORK_DESTINATION)).thenReturn(trip);
        when(ticketFeesRepositoryPort.byTripId(trip.getId())).thenReturn(ticketFees);

        BigDecimal TicketTotalPrice = new TravelPricer(ticketFeesRepositoryPort, tripRepositoryPort).priceTrip(PARIS_STRING, NEWYORK_DESTINATION);

        assertEquals(BigDecimal.valueOf(1050), TicketTotalPrice);
    }

}
