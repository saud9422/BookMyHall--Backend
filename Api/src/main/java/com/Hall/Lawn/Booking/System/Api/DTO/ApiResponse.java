package com.Hall.Lawn.Booking.System.Api.DTO;

public record ApiResponse<T>(
        boolean success,
        String messege,
        T data
) {
}
