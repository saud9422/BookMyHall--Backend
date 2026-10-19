package com.Hall.Lawn.Booking.System.Api.Repository;

import com.Hall.Lawn.Booking.System.Api.Entity.Halls;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HallRepository extends JpaRepository<Halls, Long> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT h FROM Hall h WHERE h.id = :hallId")
    Optional<Halls> findByIdForUpdate(
            @Param("hallId") Long hallId
    );
}
