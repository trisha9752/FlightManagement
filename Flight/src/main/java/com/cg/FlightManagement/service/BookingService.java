package com.cg.FlightManagement.service;

import com.cg.FlightManagement.dto.Passenger;


public interface BookingService {

	public int addBooking(Passenger passenger,int currentUserId,int flightNumber) throws Exception;
	public String[] viewBookingById(int bookingId,int userId) throws Exception;
	public void deleteBooking(int bookingId,int userId) throws Exception;
}
