package com.booking.movie.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieDTO {
	
	private String movieName;
    private String genre;
    private String language;
    private List<MovieShowDTO> movieShowDTOs;

}
