package com.kata.tripagency.domain.acceptance.steps;

import com.kata.tripagency.domain.model.TicketFees;
import com.kata.tripagency.domain.model.Trip;
import com.kata.tripagency.domain.port.repositories.TicketFeesRepositoryPort;
import com.kata.tripagency.domain.port.repositories.TripRepositoryPort;
import com.kata.tripagency.domain.service.TravelPricer;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculateTravelPriceSteps {

    private Trip trip = new Trip();
    private TicketFees ticketFees = new TicketFees();

    private BigDecimal tripPrice;

    @Mock
    private TicketFeesRepositoryPort ticketFeesRepositoryPort;

    @Mock
    private TripRepositoryPort tripRepositoryPort;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Given("the trip is from {string} to {string}")
    public void thereIsATripFromTo(String dep, String dest) {
        trip.setId(1L);
        trip.setDeparture(dep);
        trip.setDestination(dest);
        Mockito.when(tripRepositoryPort.findByDepartureAndDestination(dep,dest)).thenReturn(trip);
    }

    @And("the ticketPrice is {string}")
    public void theTicketPriceIs(String ticketPrice) {
        trip.setTicketPrice(BigDecimal.valueOf(Long.parseLong(ticketPrice)));
    }

    @And("the  travel fees are {string}€ and the agency fees are {string}€")
    public void theTravelFeesAre€AndTheAgencyFeesAre€(String travelFees, String agencyFees) {
        ticketFees.setTripId(1L);
        ticketFees.setTravelFees(BigDecimal.valueOf(Long.parseLong(travelFees)));
        ticketFees.setAgencyFees(BigDecimal.valueOf(Long.parseLong(agencyFees)));
        Mockito.when(ticketFeesRepositoryPort.byTripId(1L)).thenReturn(ticketFees);
    }

    @When("the system calculate the trip price")
    public void theSystemCalculateTheTripPrice() {
        tripPrice = new TravelPricer(ticketFeesRepositoryPort, tripRepositoryPort).priceTrip(trip.getDeparture(), trip.getDestination());
    }

    @Then("the trip price is {string}€")
    public void theTripPriceIs€(String expectedPrice) {
        assertEquals(BigDecimal.valueOf(Long.parseLong(expectedPrice)),tripPrice);
    }


}