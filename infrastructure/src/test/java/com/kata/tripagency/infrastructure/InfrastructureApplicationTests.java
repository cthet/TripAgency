package com.kata.tripagency.infrastructure;

import com.kata.tripagency.domain.exception.TripNotFoundException;
import com.kata.tripagency.domain.model.Trip;
import com.kata.tripagency.infrastructure.config.AppConfig;
import com.kata.tripagency.infrastructure.repository.springdatajpa.Adapters.TripRepositoryPortJpaAdapter;
import com.kata.tripagency.infrastructure.repository.springdatajpa.Repository.TripJpaRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
@TestPropertySource(locations = "classpath:test.properties")
class InfrastructureApplicationTests {

	@Autowired
	@Qualifier("TripRepositoryJpaAdapter")
	private TripRepositoryPortJpaAdapter tripRepositoryPort;

	@Mock
	private TripJpaRepository tripJpaRepository;


	@Test
	public void givenValidDepartureAndDestination_whenGettingTrip_thenTripWithMatchingDestinationAndDepartureAreReturned() {
		String departure = "Paris";
		String destination = "New-York";

		Trip TripFromParisToNewYork = new Trip(1L, departure, destination, BigDecimal.valueOf(1000).setScale(2));

		assertEquals(TripFromParisToNewYork, tripRepositoryPort.findByDepartureAndDestination(departure, destination));
	}

	@Test
	@DisplayName("Given a nonexistent trip, when getting a trip, then a TripNotFoundException is thrown")
	void givenANonExistentTrip_whenGettingATrip_thenThrowException() {
		String departure = "Paris";
		String destination = "Paris";

		when(tripJpaRepository.findByDepartureAndDestination(departure, destination)).thenReturn(Optional.empty());

		assertThrows(TripNotFoundException.class, () -> tripRepositoryPort.findByDepartureAndDestination(departure, destination));
	}


}
