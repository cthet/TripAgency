package com.kata.tripagency.domain.exception;

public class TripNotFoundException extends RuntimeException{

    public TripNotFoundException(String message) {
        super(message);
    }
}
