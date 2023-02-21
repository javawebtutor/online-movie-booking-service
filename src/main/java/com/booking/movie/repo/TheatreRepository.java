package com.booking.movie.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.movie.entity.Location;
import com.booking.movie.entity.Theatre;

public interface TheatreRepository extends JpaRepository<Theatre, Long> {

	List<Theatre> findAllByLocation(Location location);

	List<Theatre> findAllByLocationCityContaining(String name);

}
