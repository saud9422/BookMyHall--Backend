package com.Hall.Lawn.Booking.System.Api.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginRequest(

        @NotBlank(message = "Email is required")
        String email,

        @NotBlank(message = "Password is required")
        String password

) {
}
