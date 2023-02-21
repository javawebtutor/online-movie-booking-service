package com.booking.movie.model;

import java.time.LocalTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingResponse {

	private Long bookingId;
	private String city;
	private String movieName;
	private String theatreName;
	private String screenName;
	private Long noOfSeats;
	private LocalTime startTime;
	private LocalTime endTime;
	private Float totalPrice;
	private Float totalDiscount;
	private UserDTO userDTO;

}
