package com.Hall.Lawn.Booking.System.Api.DTO;

import com.Hall.Lawn.Booking.System.Api.Enums.BookingStatus;
import com.Hall.Lawn.Booking.System.Api.Enums.BookingType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record BookingByHourDto(
        Long hall_id,
        LocalTime BookingStartTime,
        LocalTime BookingEndTime,
        BigDecimal totalAmount
) {
}
