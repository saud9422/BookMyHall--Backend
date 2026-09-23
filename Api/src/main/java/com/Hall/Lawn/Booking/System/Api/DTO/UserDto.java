package com.Hall.Lawn.Booking.System.Api.DTO;

import com.Hall.Lawn.Booking.System.Api.Enums.Role;

public record UserDto(
        String name,
        String email,
        String address,
        String phone,
        Role role
) {
}