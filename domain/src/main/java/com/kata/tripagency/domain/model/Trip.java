package com.kata.tripagency.domain.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Trip {
    private Long id;
    private String departure;
    private String destination;
    private BigDecimal ticketPrice;
    public Trip() {
    }

    public Trip(Long id, String departure, String destination, BigDecimal ticketPrice) {
        this.id = id;
        this.departure = departure;
        this.destination = destination;
        this.ticketPrice = ticketPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trip trip = (Trip) o;
        return Objects.equals(departure, trip.departure) && Objects.equals(destination, trip.destination) && Objects.equals(ticketPrice, trip.ticketPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departure, destination, ticketPrice);
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", departure='" + departure + '\'' +
                ", destination='" + destination + '\'' +
                ", ticketPrice=" + ticketPrice +
                '}';
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setTicketPrice(BigDecimal ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getDeparture() {
        return departure;
    }
}
