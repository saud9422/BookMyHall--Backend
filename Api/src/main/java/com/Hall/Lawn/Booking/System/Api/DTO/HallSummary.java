package com.Hall.Lawn.Booking.System.Api.DTO;

import com.Hall.Lawn.Booking.System.Api.Enums.HallType;

public record HallSummary(
        Long id,
        String name,
        String description,
        String location,
        Long price_per_hour,
        Long price_per_day,
        Long capacity,
        HallType halltype
) {
}
