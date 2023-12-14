package com.kata.tripagency.domain.model;

import java.math.BigDecimal;
import java.util.Objects;

public class TicketFees {
    private BigDecimal travelFees;
    private BigDecimal agencyFees;

    public TicketFees(BigDecimal travelFees, BigDecimal agencyFees) {
        this.travelFees = travelFees;
        this.agencyFees = agencyFees;
    }

    public void setTripId(Long tripId) {
    }

    public TicketFees() {
    }

    public void setTravelFees(BigDecimal travelFeesAmount) {
        this.travelFees = travelFeesAmount;
    }

    public BigDecimal getTravelFees() {
        return travelFees;
    }

    public BigDecimal getAgencyFees() {
        return agencyFees;
    }

    public void setAgencyFees(BigDecimal agencyFees) {
        this.agencyFees = agencyFees;
    }

}
