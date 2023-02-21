package com.booking.movie.service.user;

public interface PaymentService {

	public boolean makePayment();

	public boolean isPaymentDone();

	public boolean isPaymentPending();

}
