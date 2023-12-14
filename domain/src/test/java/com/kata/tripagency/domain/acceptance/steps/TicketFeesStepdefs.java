//package com.kata.tripagency.acceptance.steps;
//
//import com.kata.tripagency.model.TicketFees;
//import com.kata.tripagency.port.repositories.TicketFeesRepositoryPort;
//import io.cucumber.datatable.DataTable;
//import io.cucumber.java.en.Given;
//
//import java.math.BigDecimal;
//import java.util.List;
//import java.util.Map;
//
//public class TicketFeesStepdefs {
//
//    TicketFeesRepositoryPort ticketFeesRepositoryPort;
//
//    public TicketFeesStepdefs(TicketFeesRepositoryPort ticketFeesRepositoryPort) {
//        this.ticketFeesRepositoryPort = ticketFeesRepositoryPort;
//    }
//
//    @Given("ticketFees exists:")
//    public void ticketfeesExists(DataTable dataTable) {
//        List<Map<String, String>> dataMaps = dataTable.asMaps(String.class, String.class);
//        dataMaps.forEach(dataMap -> {
//            TicketFees ticketFees = new TicketFees();
//            ticketFees.setTripId(Long.parseLong(dataMap.get("tripId")));
//            ticketFees.setTravelFees(BigDecimal.valueOf(Long.parseLong(dataMap.get("travelFees"))));
//            ticketFees.setAgencyFees(BigDecimal.valueOf(Long.parseLong(dataMap.get("agencyFees"))));
//            ticketFeesRepositoryPort.save(ticketFees);
//        });
//    }
//}
