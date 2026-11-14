package com.Hall.Lawn.Booking.System.Api.Controller;

import com.Hall.Lawn.Booking.System.Api.DTO.DashboardDto;
import com.Hall.Lawn.Booking.System.Api.Entity.User;
import com.Hall.Lawn.Booking.System.Api.Service.DashboardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Consumer;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {
    private final DashboardService dashboardService;
    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/get")
    public ResponseEntity<DashboardDto> getConsumerDashboard(@AuthenticationPrincipal UserDetails userDetails) {
        String username = userDetails.getUsername();
       DashboardDto Response = dashboardService.getConsumerDashboard(username);
        return ResponseEntity.status(HttpStatus.OK).body(Response);
    }
}
