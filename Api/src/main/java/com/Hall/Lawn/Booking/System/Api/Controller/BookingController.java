package com.Hall.Lawn.Booking.System.Api.Controller;

import com.Hall.Lawn.Booking.System.Api.DTO.*;
import com.Hall.Lawn.Booking.System.Api.Entity.Booking;
import com.Hall.Lawn.Booking.System.Api.Service.BookingService;
import com.Hall.Lawn.Booking.System.Api.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {
    private final BookingService bookingService;
    private final UserService userService;

    public BookingController(BookingService bookingService, UserService userService) {
        this.bookingService = bookingService;
        this.userService = userService;
    }

    @PostMapping("/saveBookingByDay")
    public ResponseEntity<ApiResponse<BookingResponseForDay>> saveBookingByDayDto(@RequestBody BookingByDayDto bookingByDayDto) {

       BookingResponseForDay booking = bookingService.getBookingByDayDto(bookingByDayDto);

       return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(
               true,
               "Booking Created Successfully",
               booking

       ));
    }

    @PostMapping("/saveBookingByHour")
    public ResponseEntity<ApiResponse<BookingResponseForHours>> saveBookingByHourDto(@RequestBody BookingByHourDto bookingByHourDto) {

        BookingResponseForHours booking = bookingService.getBookingByHourDto(bookingByHourDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(
                true,
                "Booking Created Successfully",
                booking
        ));
    }

    @GetMapping("/getbyId")
    public ResponseEntity<Booking> getBookingById(@RequestParam Long id){
        if(bookingService.getBookingById(id) == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }else {
            return ResponseEntity.ok(bookingService.getBookingById(id));
        }
    }

    @GetMapping("/getbybookingId")
    public ResponseEntity<List<Booking>> getBookingByHallId(@RequestParam Long hallId){
        if(bookingService.getBookingByHallId(hallId) == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }else {
            return ResponseEntity.ok(bookingService.getBookingByHallId(hallId));
        }
    }

    @GetMapping("/getbyuserId")
    public ResponseEntity<List<Booking>> getBookingByUserId(@RequestParam Long userId){
        if (bookingService.getBookingByUserId(userId) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }else {
            return ResponseEntity.ok(bookingService.getBookingByUserId(userId));
        }
    }
}
