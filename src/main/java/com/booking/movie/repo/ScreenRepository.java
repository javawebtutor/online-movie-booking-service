package com.booking.movie.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.movie.entity.Screen;

public interface ScreenRepository extends JpaRepository<Screen, Long> {

}
