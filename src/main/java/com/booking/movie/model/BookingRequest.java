package com.booking.movie.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingRequest {
	
	private String city;
    private String movieName;
    private Long showId;
    private Long theatreId;
    private Long noOfSeat;
    private UserDTO userDTO;

}
