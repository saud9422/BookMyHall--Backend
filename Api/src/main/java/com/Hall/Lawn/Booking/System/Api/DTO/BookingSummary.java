package com.Hall.Lawn.Booking.System.Api.DTO;

import com.Hall.Lawn.Booking.System.Api.Enums.BookingStatus;
import com.Hall.Lawn.Booking.System.Api.Enums.BookingType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public record BookingSummary(
        Long bookingId,
        BookingType bookingType,
        BookingStatus bookingStatus,
        LocalDate bookingDate,
        LocalDate bookingStartDate,
        LocalDate bookingEndDate,
        LocalTime bookingStartTime,
        LocalTime bookingEndTime,
        Integer totalBookingHours,
        BigDecimal totalAmount,
        String hallName,
        String hallLocation
) {
}
