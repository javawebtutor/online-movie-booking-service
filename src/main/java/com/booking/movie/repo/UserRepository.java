package com.booking.movie.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.movie.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUserName(String username);

}
