package com.booking.movie.service.user;

import java.util.List;

import com.booking.movie.entity.Booking;
import com.booking.movie.model.BookingRequest;
import com.booking.movie.model.BookingResponse;

public interface BookingService {
	
	BookingResponse bookMyShow(BookingRequest bookingRequest);
	List<Booking> getAllBookings();

}
