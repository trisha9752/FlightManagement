package com.cg.FlightManagement.service;

import java.time.format.DateTimeFormatter;
import java.util.Properties;

import com.cg.FlightManagement.dao.BookingImpl;
import com.cg.FlightManagement.dao.DatabaseLocationDao;
import com.cg.FlightManagement.dao.FlightManagementImpl;
import com.cg.FlightManagement.dao.PropertyFileImpl;
import com.cg.FlightManagement.dto.Booking;
import com.cg.FlightManagement.dto.Flight;
import com.cg.FlightManagement.dto.Passenger;
import com.cg.FlightManagement.utilities.BookingValidation;


public class BookingServiceImpl extends BookingImpl implements BookingService{
	
	BookingValidation validator = new BookingValidation();
	Properties database;
	Booking booking = new Booking();
	Flight flight = new Flight();
	PropertyFileImpl propertyFile = new PropertyFileImpl();
	FlightServiceImpl flightServices;
	{
		try {
			flightServices = new FlightServiceImpl();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public int addBooking(Passenger passenger,int currentUserId,int flightNumber) throws Exception{
		int totalPassengers = flightServices.getNoOfPassengers(flightNumber);
		int bookingId = this.generateBookingId();
			//Adding information to booking class
			database = propertyFile.read(DatabaseLocationDao.booking);
			booking.setBookingId(bookingId);
			booking.setUserId(currentUserId);
			booking.setNoOfPassengers(totalPassengers);
			booking.setFlight(flightNumber);
			DateTimeFormatter date = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			booking.setBookingDate(java.time.LocalDate.now().format(date));
			booking.setTicketCost(flightServices.getCostFromDatabase(flightNumber));
			//Adding flight information to flight class
			flight.setSeatCapacity(totalPassengers);
			flight.setFlightModel(flightServices.getFlightModelFromDatabase(flightNumber));
			flight.setFlightNumber(flightNumber);
			flight.setCarrierName(flightServices.getFlightNameFromDatabase(flightNumber));

			passenger.setPnrNumber(generatePnr());
			validator.validate(passenger);
			this.addBookingToBooking(booking,flightNumber,passenger.getPnrNumber());
			this.addBookingToPassenger(passenger);
			return bookingId;
	}


	@Override
	public String[] viewBookingById(int bookingId,int userId) throws Exception {
		String[] bookingList = this.getBookingFromBooking(bookingId);
		if (userId == Integer.parseInt(bookingList[1])) {
			String[] passengerList = this.getBookingFromPassengers(bookingList[3]);
			return FlightManagementImpl.concatenateArray(bookingList, passengerList);
		}else
			throw new Exception();
	}
	@Override
	public void deleteBooking(int bookingId,int userId) throws Exception {
		String[] bookingList = this.getBookingFromBooking(bookingId);
		if (userId == Integer.parseInt(bookingList[1])) {
			this.deleteBookingFromBooking(bookingId);
			this.deleteBookingFromPassengers(bookingList[3]);
		}else
			throw new ArrayIndexOutOfBoundsException();
	}
}