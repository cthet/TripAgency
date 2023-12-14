package com.kata.tripagency.domain.exception;

public class InvalidDepartureException extends RuntimeException{

    public InvalidDepartureException(String message) {
        super(message);
    }
}
