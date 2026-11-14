package com.Hall.Lawn.Booking.System.Api.Exception;

public class BookingConflictException extends RuntimeException {
    public BookingConflictException(String message) {
        super(message);
    }
}
