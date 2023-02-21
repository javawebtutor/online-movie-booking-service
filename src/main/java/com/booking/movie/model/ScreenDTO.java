package com.booking.movie.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScreenDTO {
	
	private String screenName;
    private Integer noOfSeats;
    private List<MovieShowDTO> movieShowDTOs;

}
