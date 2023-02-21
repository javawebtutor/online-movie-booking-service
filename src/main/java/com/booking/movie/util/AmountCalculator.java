package com.booking.movie.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.booking.movie.model.Amount;

@Component
public class AmountCalculator {

	@Value("${user.discount.seat}")
	private String seatLimit;

	@Value("${user.discount.rate}")
	private String rate;

	@Value("${theatre.show.priceperseat}")
	private String pricePerSeat;

	public Amount calculateAmount(Long noOfSeatToBook) {
		Amount ticket = new Amount();
		float discountPercent = Float.valueOf(rate + "f");
		float seatPrice = Float.valueOf(pricePerSeat + "f");
		//Integer discountSeat = Integer.valueOf(seatLimit);
		float ticketAmount;
		float fullAmount = seatPrice * noOfSeatToBook;
		if (noOfSeatToBook >= 3)
			ticketAmount = fullAmount - ((seatPrice * noOfSeatToBook) / discountPercent);
		else
			ticketAmount = fullAmount;

		ticket.setTicketAmount(ticketAmount);
		ticket.setDiscountAmount(fullAmount - ticketAmount);
		return ticket;
	}

}
