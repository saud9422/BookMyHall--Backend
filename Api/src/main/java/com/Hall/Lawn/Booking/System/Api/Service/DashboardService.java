package com.Hall.Lawn.Booking.System.Api.Service;

import com.Hall.Lawn.Booking.System.Api.DTO.BookingSummary;
import com.Hall.Lawn.Booking.System.Api.DTO.DashboardDto;
import com.Hall.Lawn.Booking.System.Api.DTO.HallSummary;
import com.Hall.Lawn.Booking.System.Api.DTO.UserDto;
import com.Hall.Lawn.Booking.System.Api.Entity.Booking;
import com.Hall.Lawn.Booking.System.Api.Entity.Halls;
import com.Hall.Lawn.Booking.System.Api.Entity.User;
import com.Hall.Lawn.Booking.System.Api.Enums.Role;
import com.Hall.Lawn.Booking.System.Api.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DashboardService {

    private final UserRepository userRepository;

    public DashboardService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public DashboardDto getConsumerDashboard(String username) {
        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("Username not found");
        }

        List<BookingSummary> bookings = new ArrayList<>();
        for (Booking booking : user.getBookings()) {
            bookings.add(toBookingSummary(booking));
        }

        List<HallSummary> halls = new ArrayList<>();
        if (user.getRole() == Role.ADMIN || user.getRole() == Role.HALL) {
            for (Halls hall : user.getHalls()) {
                halls.add(toHallSummary(hall));
            }
        }

        return new DashboardDto(toUserDto(user), bookings, halls);
    }

    private UserDto toUserDto(User user) {
        return new UserDto(
                user.getName(),
                user.getEmail(),
                user.getAddress(),
                user.getPhone(),
                user.getRole()
        );
    }

    private BookingSummary toBookingSummary(Booking booking) {
        Halls hall = booking.getHall();
        return new BookingSummary(
                booking.getBookingId(),
                booking.getBookingType(),
                booking.getBookingStatus(),
                booking.getBookingDate(),
                booking.getBookingStartDate(),
                booking.getBookingEndDate(),
                booking.getBookingStartTime(),
                booking.getBookingEndTime(),
                booking.getTotalBookingHours(),
                booking.getTotalAmount(),
                hall == null ? null : hall.getName(),
                hall == null ? null : hall.getLocation()
        );
    }

    private HallSummary toHallSummary(Halls hall) {
        return new HallSummary(
                hall.getId(),
                hall.getName(),
                hall.getDescription(),
                hall.getLocation(),
                hall.getPrice_per_hour(),
                hall.getPrice_per_day(),
                hall.getCapacity(),
                hall.getHalltype()
        );
    }
}
