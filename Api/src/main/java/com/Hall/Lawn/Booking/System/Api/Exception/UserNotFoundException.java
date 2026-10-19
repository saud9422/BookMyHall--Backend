package com.Hall.Lawn.Booking.System.Api.Exception;

// Thrown when a user is not found -> HTTP 404
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }
}
