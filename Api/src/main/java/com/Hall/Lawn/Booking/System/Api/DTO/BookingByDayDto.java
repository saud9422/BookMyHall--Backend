package com.Hall.Lawn.Booking.System.Api.DTO;

import com.Hall.Lawn.Booking.System.Api.Enums.BookingStatus;
import com.Hall.Lawn.Booking.System.Api.Enums.BookingType;

import java.math.BigDecimal;
import java.time.LocalDate;

public record BookingDto(
        Long hall_id,
        BookingType type,
        LocalDate bookingDate,
        LocalDate bookingStartTime,
        LocalDate bookingEndTime,
        Integer totalBookingHours,
        BookingStatus bookingStatus,
        BigDecimal totalAmount


) {

}
