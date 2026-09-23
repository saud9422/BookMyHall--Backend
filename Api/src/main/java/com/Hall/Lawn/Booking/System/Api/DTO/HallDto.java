package com.Hall.Lawn.Booking.System.Api.DTO;

import com.Hall.Lawn.Booking.System.Api.Enums.HallType;

public record HallDto(
        String name,
        String description,
        String location,
        long price_per_hour,
        long price_per_day,
        HallType hallType,
        String capacity,
        String imageUrl
) {
}
