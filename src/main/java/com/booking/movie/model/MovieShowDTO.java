package com.booking.movie.model;

import java.time.LocalTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieShowDTO {

	private String showName;
	private LocalTime startTime;
	private LocalTime endTime;
	private Long totalSeat;
	private Long availableSeat;
	private String screenName;
	private String theatreName;
	private String city;

}
