package com.booking.movie.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="MOVIE_USER")
@Setter
@Getter
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(value = AccessLevel.NONE)
    private Long id;

    @Column(name="USERNAME")
    private String userName;

    @Column(name="CONTACT_NO")
    private String contactNo;

    @Column(name="EMAIL")
    private String email;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Booking> bookingList = new ArrayList<>();
    
  //making bidirectional
    public User addBooking(Booking booking){
        booking.setUser(this);
        bookingList.add(booking);
        return this;
    }

	
	

}
