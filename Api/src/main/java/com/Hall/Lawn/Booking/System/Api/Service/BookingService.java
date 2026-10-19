package com.Hall.Lawn.Booking.System.Api.Service;

import com.Hall.Lawn.Booking.System.Api.DTO.BookingByDayDto;
import com.Hall.Lawn.Booking.System.Api.DTO.BookingByHourDto;
import com.Hall.Lawn.Booking.System.Api.Entity.Booking;
import com.Hall.Lawn.Booking.System.Api.Entity.Halls;
import com.Hall.Lawn.Booking.System.Api.Entity.User;
import com.Hall.Lawn.Booking.System.Api.Enums.BookingStatus;
import com.Hall.Lawn.Booking.System.Api.Enums.BookingType;
import com.Hall.Lawn.Booking.System.Api.Repository.BookingRepository;
import com.Hall.Lawn.Booking.System.Api.Repository.HallRepository;
import com.Hall.Lawn.Booking.System.Api.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
    public Booking getBookingByDayDto(BookingByDayDto bookingByDayDto){
       Optional<Halls> hall = hallRepository.findByIdForUpdate(bookingByDayDto.hall_id());
       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       String username = authentication.getName();
       User user = userRepository.findByEmail(username);

        boolean conflict = bookingRepository.existsOverlappingBooking(
                bookingByDayDto.hall_id(),
                bookingByDayDto.bookingStartDate(),
                bookingByDayDto.bookingEndDate(),
                BookingStatus.Cancelled
        );



       if(user == null){
           return null;
       }

       if(hall.isEmpty()){
           return null;
       }
       Booking booking = new Booking();
       booking.setHall(hall.get());
       booking.setBookingType(BookingType.Days);
       booking.setBookingStartDate(bookingByDayDto.bookingStartDate());
       booking.setBookingEndDate(bookingByDayDto.bookingEndDate());
       booking.setBookingStatus(BookingStatus.Pending);
       booking.setTotalAmount(bookingByDayDto.totalAmount());
       bookingRepository.save(booking);
       return booking;
   }
    @Transactional
    public Booking getBookingByHourDto(BookingByHourDto bookingByHourDto){
        Optional<Halls> hall = hallRepository.findByIdForUpdate(bookingByHourDto.hall_id());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userRepository.findByEmail(username);

        if(user == null){
            return null;
        }
        if(hall == null){
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
        return booking;
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
