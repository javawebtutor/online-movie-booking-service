package com.booking.movie.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.movie.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
