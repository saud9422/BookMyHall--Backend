package com.Hall.Lawn.Booking.System.Api.DTO;

import java.util.List;

public record DashboardDto(
        UserDto user,
        List<BookingSummary> bookings,
        List<HallSummary> halls
) {
}
