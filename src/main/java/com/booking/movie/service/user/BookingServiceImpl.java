package com.booking.movie.service.user;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.movie.entity.Booking;
import com.booking.movie.entity.MovieShow;
import com.booking.movie.entity.User;
import com.booking.movie.model.Amount;
import com.booking.movie.model.BookingRequest;
import com.booking.movie.model.BookingResponse;
import com.booking.movie.model.UserDTO;
import com.booking.movie.repo.BookingRepository;
import com.booking.movie.repo.MovieShowRepository;
import com.booking.movie.repo.UserRepository;
import com.booking.movie.util.AmountCalculator;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private MovieShowRepository movieShowRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AmountCalculator amountCalculator;

	Logger LOG = LoggerFactory.getLogger(BookingServiceImpl.class);

	@Override
	public BookingResponse bookMyShow(BookingRequest bookingRequest) {
		LOG.info("Inside bookMyShow(BookingRequest bookingRequest) method with {} request param", bookingRequest);
		Optional<MovieShow> optionalMovieShow = movieShowRepository.findById(bookingRequest.getShowId());
		optionalMovieShow.orElseThrow(() -> {
			LOG.error("Incorrect show id", bookingRequest.getShowId());
			return new RuntimeException("Incorrect show id..");
		});
		MovieShow movieShow = optionalMovieShow.get();
		Optional<User> optionalUser = userRepository.findByUserName(bookingRequest.getUserDTO().getUsername());
		UserDTO userDTO = bookingRequest.getUserDTO();
		boolean isExistingUser = optionalUser.isPresent();
		User savedUser = null;
		Booking savedBooking = null;
		BookingResponse bookingResponse = null;
		if (!isExistingUser) {
			LOG.info("Found new user save it {}", bookingRequest.getUserDTO());
			User user = new User();
			user.setUserName(userDTO.getUsername());
			user.setEmail(userDTO.getEmail());
			user.setContactNo(userDTO.getContactNo());
			LOG.info("Invoking UserRepository::save() with {} user details", bookingRequest.getUserDTO());
			savedUser = userRepository.save(user);
		} else {
			LOG.info("Found existing user {}", bookingRequest.getUserDTO());
			savedUser = optionalUser.get();
		}
		LOG.info("Total {} available seat for show name {} movie name {}", movieShow.getAvailableSeat(),
				movieShow.getShowName(), movieShow.getMovie().getName());
		if (movieShow.getAvailableSeat() > bookingRequest.getNoOfSeat()) {

			Booking booking = new Booking();
			booking.setMovieShow(movieShow);
			booking.setUser(savedUser);
			booking.setNoOfSeatBooked(bookingRequest.getNoOfSeat());
			Amount amount = amountCalculator.calculateAmount(bookingRequest.getNoOfSeat());
			if (makePayment(userDTO, amount.getTicketAmount())) {
				movieShow.setAvailableSeat(movieShow.getAvailableSeat() - bookingRequest.getNoOfSeat());
				movieShow.setBookedSeat(bookingRequest.getNoOfSeat());
				booking.setTicketAmount(amount.getTicketAmount());
				LOG.info("Updating movie show entity for total available seat {} and booked seat {}",
						movieShow.getAvailableSeat(), movieShow.getBookedSeat());
				movieShowRepository.save(movieShow);
				LOG.info("Making a final Booking call BookingRepository::save with {}", bookingRequest);
				savedBooking = bookingRepository.save(booking);
				bookingResponse = createBookingResponse(savedBooking, bookingRequest);
				bookingResponse.setTotalDiscount(amount.getDiscountAmount());

			} else {
				LOG.error("Payment declined of {} by user {}", amount.getTicketAmount(), userDTO.getUsername());
				throw new RuntimeException("Payment Declined.. Ticket not booked...");
			}
		} else {
			LOG.error("Requested seat: {} and available seat: {}", bookingRequest.getNoOfSeat(),
					movieShow.getAvailableSeat());
			throw new RuntimeException("Requested seat not available..");
		}

		return bookingResponse;
	}
	
	@Override
	public List<Booking> getAllBookings() {
		 return bookingRepository.findAll();
	}

	private BookingResponse createBookingResponse(Booking booking, BookingRequest bookingRequest) {
		BookingResponse bookingResponse = new BookingResponse();
		bookingResponse.setBookingId(booking.getId());
		bookingResponse.setMovieName(booking.getMovieShow().getMovie().getName());
		bookingResponse.setNoOfSeats(booking.getNoOfSeatBooked());
		bookingResponse.setTheatreName(booking.getMovieShow().getScreen().getTheatre().getTheatreName());
		bookingResponse.setCity(bookingRequest.getCity());
		bookingResponse.setScreenName(booking.getMovieShow().getScreen().getScreenName());
		bookingResponse.setStartTime(booking.getMovieShow().getStartTime());
		bookingResponse.setEndTime(booking.getMovieShow().getEndTime());
		bookingResponse.setTotalPrice(booking.getTicketAmount());
		bookingResponse.setUserDTO(bookingRequest.getUserDTO());
		return bookingResponse;
	}

//mock call integrate payment service call here
	private boolean makePayment(UserDTO userDTO, float paymentAmount) {
		LOG.info("Requesting for Payment of {} by user {}", paymentAmount, userDTO.getUsername());
		// integrate payment service call
		LOG.info("Requested Payment of {} by user {} completed", paymentAmount, userDTO.getUsername());
		return true;
	}

	

}
