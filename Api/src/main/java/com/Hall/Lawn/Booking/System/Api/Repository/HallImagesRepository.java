package com.Hall.Lawn.Booking.System.Api.Repository;

import com.Hall.Lawn.Booking.System.Api.Entity.Hall_Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HallImagesRepository extends JpaRepository<Hall_Images,Long> {

}
