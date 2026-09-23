package com.Hall.Lawn.Booking.System.Api.Repository;

import com.Hall.Lawn.Booking.System.Api.Entity.Halls;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HallRepository extends JpaRepository<Halls, Long> {

}
