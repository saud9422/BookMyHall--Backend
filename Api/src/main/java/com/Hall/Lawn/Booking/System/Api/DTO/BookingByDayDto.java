package com.Hall.Lawn.Booking.System.Api.DTO;

import com.Hall.Lawn.Booking.System.Api.Enums.BookingStatus;
import com.Hall.Lawn.Booking.System.Api.Enums.BookingType;

import java.math.BigDecimal;
import java.time.LocalDate;

public record BookingByDayDto(
        Long hall_id,
        LocalDate bookingStartDate,
        LocalDate bookingEndDate,
        BigDecimal totalAmount
) {
}
