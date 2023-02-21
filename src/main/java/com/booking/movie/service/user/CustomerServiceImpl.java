package com.booking.movie.service.user;

import org.springframework.stereotype.Service;

import com.booking.movie.entity.User;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	//For managing the users and Roles we need to implement authorization Server. User
	//need to register first. Based on users access and Roles it will generate token to access 
	//the API.
	//for faster development we can utilize keycloak(Opensource), Okta or AWS cognito
	

	@Override
	public User registerUser(User user) {
		return null;
	}

	@Override
	public User deleteUser(User user) {
		return null;
	}

	@Override
	public User updateUser(User user) {
		return null;
	}

	@Override
	public User fetchUser(User user) {
		return null;
	}

}
