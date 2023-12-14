package com.kata.tripagency.infrastructure.repository.springdatajpa.Entity;

import com.kata.tripagency.domain.model.TicketFees;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "ticket_fees")
public class TicketFeesEntity {

    @Id
    private Long id;

    private BigDecimal travelFees;

    private BigDecimal agencyFees;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private TripEntity tripEntity;

    public TicketFeesEntity() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketFeesEntity that = (TicketFeesEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(travelFees, that.travelFees) && Objects.equals(agencyFees, that.agencyFees) && Objects.equals(tripEntity, that.tripEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, travelFees, agencyFees, tripEntity);
    }

    public TicketFees convertToTicketFees() {
        return new TicketFees(travelFees, agencyFees);
    }

}
