package com.Hall.Lawn.Booking.System.Api.Service;
import java.util.*;
import com.Hall.Lawn.Booking.System.Api.DTO.BookingByDayDto;
import com.Hall.Lawn.Booking.System.Api.DTO.BookingByHourDto;
import com.Hall.Lawn.Booking.System.Api.DTO.BookingResponseForDay;
import com.Hall.Lawn.Booking.System.Api.DTO.BookingResponseForHours;
import com.Hall.Lawn.Booking.System.Api.Entity.Booking;
import com.Hall.Lawn.Booking.System.Api.Entity.Halls;
import com.Hall.Lawn.Booking.System.Api.Entity.User;
import com.Hall.Lawn.Booking.System.Api.Enums.BookingStatus;
import com.Hall.Lawn.Booking.System.Api.Enums.BookingType;
import com.Hall.Lawn.Booking.System.Api.Exception.BookingConflictException;
import com.Hall.Lawn.Booking.System.Api.Exception.HallNotFound;
import com.Hall.Lawn.Booking.System.Api.Exception.UserNotFoundException;
import com.Hall.Lawn.Booking.System.Api.Repository.BookingRepository;
import com.Hall.Lawn.Booking.System.Api.Repository.HallRepository;
import com.Hall.Lawn.Booking.System.Api.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final HallRepository hallRepository;
    private final UserRepository userRepository;

    public BookingService(BookingRepository bookingRepository, HallRepository hallRepository, UserRepository userRepository) {
        this.hallRepository = hallRepository;
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;

    }
    @Transactional
    public BookingResponseForDay getBookingByDayDto(BookingByDayDto bookingByDayDto){
       Optional<Halls> hall = hallRepository.findByIdForUpdate(bookingByDayDto.hall_id());
       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       String username = authentication.getName();
       User user = userRepository.findByEmail(username);

       if(hall.isEmpty()){
            throw new HallNotFound("Hall not found");
        }
        boolean conflict = bookingRepository.existsOverlappingBooking(
                bookingByDayDto.hall_id(),
                bookingByDayDto.bookingStartDate(),
                bookingByDayDto.bookingEndDate(),
                BookingStatus.Cancelled
        );

        if (conflict) {
            throw new BookingConflictException("Booking already exists for request date");
        }

       if(user == null){
           throw new UserNotFoundException("User not found");
       }


       Booking booking = new Booking();
       booking.setHall(hall.get());
       booking.setBookingUser(user);
       booking.setBookingType(BookingType.Days);
       booking.setBookingStartDate(bookingByDayDto.bookingStartDate());
       booking.setBookingEndDate(bookingByDayDto.bookingEndDate());
       booking.setBookingStatus(BookingStatus.Pending);
       booking.setTotalAmount(bookingByDayDto.totalAmount());
       bookingRepository.save(booking);

       return new BookingResponseForDay(
               booking.getBookingId(),
               booking.getHall().getId(),
               booking.getHall().getName(),
               booking.getBookingStartDate(),
               booking.getBookingEndDate(),
               booking.getTotalAmount(),
               booking.getBookingStatus()

       );
   }
    @Transactional
    public BookingResponseForHours getBookingByHourDto(BookingByHourDto bookingByHourDto){
        Optional<Halls> hall = hallRepository.findByIdForUpdate(bookingByHourDto.hall_id());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userRepository.findByEmail(username);

        if(hall.isEmpty()){
            throw new HallNotFound("Hall not found");
        }

        boolean conflict = bookingRepository.existOverlappingByHoursBooking(
                bookingByHourDto.hall_id(),
                bookingByHourDto.bookingDate(),
                bookingByHourDto.BookingStartTime(),
                bookingByHourDto.BookingEndTime(),
                BookingStatus.Cancelled
        );
        if(conflict){
            throw new BookingConflictException("The Booking Already Exist for Given Time");
        }

        if(user == null){
            return null;
        }

        Booking booking = new Booking();
        booking.setHall(hall.get());
        booking.setBookingUser(user);
        booking.setBookingType(BookingType.Hours);
        booking.setBookingStartTime(bookingByHourDto.BookingStartTime());
        booking.setBookingEndTime(bookingByHourDto.BookingEndTime());
        booking.setBookingStatus(BookingStatus.Pending);
        booking.setTotalAmount(bookingByHourDto.totalAmount());
        bookingRepository.save(booking);
        return new BookingResponseForHours(
                booking.getBookingId(),
                booking.getHall().getId(),
                booking.getHall().getName(),
                booking.getBookingDate(),
                booking.getBookingStartTime(),
                booking.getBookingEndTime(),
                booking.getTotalAmount(),
                booking.getBookingStatus()
        );
    }


    public Booking getBookingById(Long id){

        return bookingRepository.findById(id).orElse(null);
    }

    public List<Booking> getBookingByHallId(Long hallId){
        return bookingRepository.getBookingByHallId(hallId);
    }

    public List<Booking> getBookingByUserId(Long userId){
        return bookingRepository.getBookingByUserId(userId);
    }
}
