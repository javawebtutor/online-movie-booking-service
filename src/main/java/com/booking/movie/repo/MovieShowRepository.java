package com.booking.movie.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.movie.entity.MovieShow;

public interface MovieShowRepository extends JpaRepository<MovieShow, Long> {

	Optional<MovieShow> findMovieShowByShowName(String name);

	Optional<MovieShow> findMovieShowById(Long id);

}
