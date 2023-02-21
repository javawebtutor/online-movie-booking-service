package com.booking.movie.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.movie.entity.Booking;
import com.booking.movie.model.BookingRequest;
import com.booking.movie.model.BookingResponse;
import com.booking.movie.service.user.BookingService;

@RestController
@RequestMapping("/api/v1")
public class BookingController {
	
	Logger LOG = LoggerFactory.getLogger(BookingController.class);

    @Autowired
    private BookingService bookingService;
    
    @PostMapping("/booking")
    public ResponseEntity<BookingResponse> bookMovieShow(@RequestBody BookingRequest bookingRequest){
    	LOG.info("BookingController invoked bookShow() method with {} parameters",bookingRequest);
    	BookingResponse bookingResponse = bookingService.bookMyShow(bookingRequest);
    	LOG.info("BookingController invoked bookShow() end..");
    	return new ResponseEntity<BookingResponse>(bookingResponse, HttpStatus.CREATED);
    	
    }
    
    @GetMapping("/booking")
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }
    
//    @GetMapping
//    public ResponseEntity<BookingResponse> getBookingById(Long id){
//    	
//    }

}
