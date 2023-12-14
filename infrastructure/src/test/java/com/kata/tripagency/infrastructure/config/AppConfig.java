package com.kata.tripagency.infrastructure.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.kata.tripagency"})
@EnableJpaRepositories("com.kata.tripagency.infrastructure.repository.springdatajpa")
@EntityScan("com.kata.tripagency.infrastructure.repository.springdatajpa")
public class AppConfig {
}
