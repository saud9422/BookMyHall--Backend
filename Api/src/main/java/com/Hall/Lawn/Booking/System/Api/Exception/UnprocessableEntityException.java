package com.Hall.Lawn.Booking.System.Api.Exception;

// Thrown when the request content is invalid (e.g. missing fields, duplicate email) -> HTTP 422
public class UnprocessableEntityException extends RuntimeException {

    public UnprocessableEntityException(String message) {
        super(message);
    }
}
