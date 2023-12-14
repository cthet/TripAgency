//package com.kata.tripagency.acceptance.steps;
//
//import com.kata.tripagency.model.Trip;
//import com.kata.tripagency.port.repositories.TripRepositoryPort;
//import io.cucumber.datatable.DataTable;
//import io.cucumber.java.en.Given;
//
//import java.math.BigDecimal;
//import java.util.List;
//import java.util.Map;
//
//public class TripSteps {
//
//    TripRepositoryPort tripRepositoryPort;
//
//    public TripSteps(TripRepositoryPort tripRepositoryPort) {
//        this.tripRepositoryPort = tripRepositoryPort;
//    }
//    @Given("trip exists:")
//    public void someTripExists(DataTable dataTable) {
//        List<Map<java.lang.String, java.lang.String>> dataMaps = dataTable.asMaps(java.lang.String.class, java.lang.String.class);
//        dataMaps.forEach(dataMap -> {
//            Trip trip = new Trip();
//            trip.setId(Long.parseLong(dataMap.get("id")));
//            trip.setDeparture(dataMap.get("departure"));
//            trip.setDestination(dataMap.get("destination"));
//            trip.setTicketPrice(BigDecimal.valueOf(Long.parseLong(dataMap.get("ticketPrice"))));
//            tripRepositoryPort.save(trip);
//    });
//    }
//}
