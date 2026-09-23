package com.Hall.Lawn.Booking.System.Api.DTO;

import com.Hall.Lawn.Booking.System.Api.Enums.Gender;
import com.Hall.Lawn.Booking.System.Api.Enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterRequest(

        // User fields
        @NotBlank(message = "Name is required")
        String name,

        @NotBlank(message = "Email is required")
        String email,

        @NotBlank(message = "Password is required")
        @Size(min = 6, message = "Password must be at least 6 characters")
        String password,

        @NotBlank(message = "Address is required")
        String address,

        @NotBlank(message = "Phone is required")
        String phone,

        Gender gender,
        Role role

) {
}