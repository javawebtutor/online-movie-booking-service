package com.booking.movie.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TheatreDTO {
	
	private String theatreName;
    private Integer noOfScreen;
    private String city;
    private List<ScreenDTO> screenDTOs;

}
