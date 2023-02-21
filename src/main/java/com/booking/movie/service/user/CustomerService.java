package com.booking.movie.service.user;

import com.booking.movie.entity.User;

public interface CustomerService {
	
	public User registerUser(User user);
    public User deleteUser(User user);
    public User updateUser(User user);
    public User fetchUser(User user);

}
