package com.booking.movie.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.movie.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

	Optional<Movie> findMovieByName(String name);

	Optional<Movie> findFirstByNameContaining(String name);

	List<Movie> findMovieByNameContaining(String name);

	List<Movie> findMovieByGenreContaining(String genre);

}
