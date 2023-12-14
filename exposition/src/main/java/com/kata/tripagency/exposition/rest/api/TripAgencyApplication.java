package com.kata.tripagency.exposition.rest.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.kata.tripagency"})
@EnableJpaRepositories("com.kata.tripagency.infrastructure.repository.springdatajpa")
@EntityScan("com.kata.tripagency.infrastructure.repository.springdatajpa")
public class TripAgencyApplication {

	public static void main(String[] args) {
		SpringApplication.run(TripAgencyApplication.class, args);
	}

}
