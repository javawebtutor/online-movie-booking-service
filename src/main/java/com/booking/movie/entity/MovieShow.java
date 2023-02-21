package com.booking.movie.entity;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "MOVIE_SHOW")
@Getter
@Setter
public class MovieShow {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SHOW_ID")
	private Long id;

	@Column(name = "SHOW_NAME")
	private String showName;

	@Column(name = "START_TIME")
	private LocalTime startTime;

	@Column(name = "END_TIME")
	private LocalTime endTime;

	@Column(name = "TOTAL_SEAT")
	private Long totalSeat;

	@Column(name = "AVAILABLE_SEAT")
	private Long availableSeat;

	@Column(name = "BOOKED_SEAT")
	private Long bookedSeat;

	@Column(name = "PRICE")
	private Float price;

	@ManyToOne
	@JoinColumn(name = "MOVIE_ID")
	private Movie movie;

	@ManyToOne
	@JoinColumn(name = "SCREEN_ID")
	private Screen screen;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "movieShow")
	private List<Booking> bookingList = new ArrayList<>();

	public MovieShow() {
	}

	public MovieShow(String showName, LocalTime startTime, LocalTime endTime, Long totalSeat, Long availableSeat,
			Long bookedSeat, Movie movie, Screen screen) {
		this.showName = showName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.totalSeat = totalSeat;
		this.availableSeat = availableSeat;
		this.bookedSeat = bookedSeat;
		this.movie = movie;
		this.screen = screen;
	}

	// Bidirectional
	public MovieShow addBooking(Booking booking) {
		booking.setMovieShow(this);
		bookingList.add(booking);
		return this;
	}

}
