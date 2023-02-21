package com.booking.movie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "BOOKING")
@Getter
@Setter
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BOOKING_ID")
	private Long id;

	@Column(name = "NO_SEAT_BOOKED")
	private Long noOfSeatBooked;

	@Column(name = "TICKET_AMOUNT")
	private Float ticketAmount;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;
	
	@ManyToOne
    @JoinColumn(name="SHOW_ID")
    private MovieShow movieShow;

}
