package com.Hall.Lawn.Booking.System.Api.Repository;

import com.Hall.Lawn.Booking.System.Api.Entity.Booking;
import com.Hall.Lawn.Booking.System.Api.Enums.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Query("select b from Booking b where b.hall.id = :hallId")
    public List<Booking> getBookingByHallId(@Param("hallId") Long hallId);

    @Query("select b from Booking b where b.bookingUser.id = :userId")
    public List<Booking> getBookingByUserId(@Param("userId") Long userId);

    @Query("""
    SELECT CASE WHEN COUNT(b) > 0 THEN true ELSE false END
    FROM Booking b
    WHERE b.hall.id = :hallId
      AND b.bookingStartDate <= :endDate
      AND b.bookingEndDate >= :startDate
      AND b.bookingStatus <> :cancelledStatus
""")
    boolean existsOverlappingBooking(
            @Param("hallId") Long hallId,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            @Param("cancelledStatus") BookingStatus cancelledStatus
    );

    @Query("""
    SELECT COUNT(b) > 0  
    FROM Booking b
    WHERE b.hall.id = :hallId
    AND b.bookingDate = :bookingDate
    AND b.bookingStartTime <= :endTime
    AND b.bookingEndTime >= :startTime
    AND b.bookingStatus <> :bookingStatus
""")
    boolean existOverlappingByHoursBooking(
            @Param("hallId") Long hallId,
            @Param("bookingDate") LocalDate bookingDate,
            @Param("startTime") LocalTime startTime,
            @Param("endTime") LocalTime endTime,
            @Param("bookingStatus")  BookingStatus bookingStatus

            );
}


// user 1 ==== start date = 11 oct
// user 1 ==== end date = 15 oct


//  user 2 start date = 12                                                                                                     oct
//  user 2 enddate = 14 oct