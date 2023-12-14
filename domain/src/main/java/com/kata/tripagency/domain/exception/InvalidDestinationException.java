package com.kata.tripagency.domain.exception;

public class InvalidDestinationException extends RuntimeException{

    public InvalidDestinationException(String message) {
        super(message);
    }
}
