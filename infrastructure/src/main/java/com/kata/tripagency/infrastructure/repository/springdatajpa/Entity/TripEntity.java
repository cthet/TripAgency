package com.kata.tripagency.infrastructure.repository.springdatajpa.Entity;

import com.kata.tripagency.domain.model.Trip;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "trip")
public class TripEntity {

    @Id
    private Long id;
    private String departure;
    private String destination;
    private BigDecimal ticketPrice;

    @OneToOne(mappedBy = "tripEntity", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private TicketFeesEntity ticketFeesEntity;

    public TripEntity() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TripEntity that = (TripEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(departure, that.departure) && Objects.equals(destination, that.destination) && Objects.equals(ticketPrice, that.ticketPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, departure, destination, ticketPrice);
    }

    public Trip convertToTrip() {
        return new Trip(getId(), getDeparture(), getDestination(), getTicketPrice());
    }

    public Long getId() {
        return id;
    }

    public String getDeparture() {
        return departure;
    }

    public String getDestination() {
        return destination;
    }

    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }
}
