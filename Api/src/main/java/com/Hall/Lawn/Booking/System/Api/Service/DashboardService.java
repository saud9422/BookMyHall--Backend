package com.Hall.Lawn.Booking.System.Api.Service;

import com.Hall.Lawn.Booking.System.Api.DTO.DashboardDto;
import com.Hall.Lawn.Booking.System.Api.Entity.Booking;
import com.Hall.Lawn.Booking.System.Api.Entity.Halls;
import com.Hall.Lawn.Booking.System.Api.Entity.User;
import com.Hall.Lawn.Booking.System.Api.Repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DashboardService {
   private final UserRepository userRepository;
    public DashboardService(UserRepository userRepository) {
        this.userRepository =userRepository;
    }
    public DashboardDto getConsumerDashboard(String username){
            User user =userRepository.findByEmail(username);
            if (user == null){
                throw new UsernameNotFoundException("Username not found");
            }
        DashboardDto dashboardDto = new DashboardDto();
            dashboardDto.setUser(user);
            dashboardDto.setBookings(user.getBookings());
            if (user.getRole().equals("ADMIN") || user.getRole().equals("HALL")){
                dashboardDto.setHalls(user.getHalls());
            }

            return dashboardDto;
    }
}
