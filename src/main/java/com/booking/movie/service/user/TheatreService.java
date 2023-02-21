package com.booking.movie.service.user;

import java.util.List;

import com.booking.movie.entity.Location;
import com.booking.movie.entity.Movie;
import com.booking.movie.entity.MovieShow;
import com.booking.movie.entity.Theatre;
import com.booking.movie.model.MovieDTO;
import com.booking.movie.model.TheatreListDTO;

public interface TheatreService {
	
	public TheatreListDTO getAllTheatre(String city);
	public Theatre getTheatreById(Long id);
	public List<Theatre> getAllTheatre(Location location);
	public List<MovieShow> getMovieShow(String movieName);
    public Long getAvailableSeat(Movie movie, Theatre theatre);
    MovieDTO getMovie(String movieName);

    public List<Theatre> getTheatreForAMovie(Movie movie, Location location);
    public List<Movie> getMovieListOnTheatre(Theatre theatre);

}
