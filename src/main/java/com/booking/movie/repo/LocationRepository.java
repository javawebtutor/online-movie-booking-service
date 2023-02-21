package com.booking.movie.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.movie.entity.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {

	Optional<Location> findLocationByCity(String city);

}
