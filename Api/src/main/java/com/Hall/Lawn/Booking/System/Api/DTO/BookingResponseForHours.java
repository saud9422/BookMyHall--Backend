package com.Hall.Lawn.Booking.System.Api.DTO;

import com.Hall.Lawn.Booking.System.Api.Enums.BookingStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public record BookingResponseForHours(
        Long bookingId,
        Long hallId,
        String hallName,
        LocalDate bookingDate,
        LocalTime bookingStartTime,
        LocalTime bookingEndTime,
        BigDecimal totalAmount,
        BookingStatus bookingStatus
) {
}
