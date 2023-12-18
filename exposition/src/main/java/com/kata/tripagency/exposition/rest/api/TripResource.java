package com.kata.tripagency.exposition.rest.api;

import com.kata.tripagency.exposition.handler.PriceComputorHandler;
import com.kata.tripagency.exposition.handler.RepositoryType;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping(value="/api")
public class TripResource {
    private final PriceComputorHandler priceComputorDriverPort;

    public TripResource(final PriceComputorHandler priceComputorDriverPort) {
        this.priceComputorDriverPort = priceComputorDriverPort;
    }

    @GetMapping(value={"/trip/departure/{departure}/destination/{destination}/priceTripWithHardCodedValues"}, produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BigDecimal> priceTripWithHardCodedValues(
            @PathVariable(value="departure") String departure,
            @PathVariable(value="destination") String destination) {

        return priceTrip(departure, destination, RepositoryType.JPA);
    }

    @GetMapping(value={"/trip/departure/{departure}/destination/{destination}/priceTripWithJPA"}, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BigDecimal> priceTripWithJPA(
            @PathVariable(value="departure") String departure,
            @PathVariable(value="destination") String destination) {

        return priceTrip(departure, destination, RepositoryType.JPA);
    }

    @GetMapping(value={"/trip/departure/{departure}/destination/{destination}/priceTripWithJdbcTemplate"}, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BigDecimal> priceTripWithJdbcTemplate(
            @PathVariable(value="departure") String departure,
            @PathVariable(value="destination") String destination) {

        return priceTrip(departure, destination, RepositoryType.JDBC_TEMPLATE);
    }

    private ResponseEntity<BigDecimal> priceTrip(final String departure, final String destination,
                                              final RepositoryType repositoryType) {

        BigDecimal travelPrice = priceComputorDriverPort.priceTravel(departure, destination, repositoryType);
        return new ResponseEntity<>(travelPrice, HttpStatus.OK);
    }

}
