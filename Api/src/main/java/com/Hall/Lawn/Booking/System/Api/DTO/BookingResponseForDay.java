package com.Hall.Lawn.Booking.System.Api.DTO;

import com.Hall.Lawn.Booking.System.Api.Enums.BookingStatus;

import java.math.BigDecimal;
import java.time.LocalDate;

public record BookingResponseForDay(
        Long bookingId,
        Long hallId,
        String hallName,
        LocalDate startDate,
        LocalDate endDate,
        BigDecimal totalAmount,
        BookingStatus bookingStatus
) {
}
