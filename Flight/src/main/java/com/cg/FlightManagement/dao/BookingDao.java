package com.cg.FlightManagement.dao;

import com.cg.FlightManagement.dto.Booking;
import com.cg.FlightManagement.dto.Passenger;

public interface BookingDao {
    void addBookingToBooking(Booking booking, int flightNumber, int pnrNumber) throws Exception;
    void addBookingToPassenger(Passenger passenger) throws Exception;
    void deleteBookingFromPassengers(String pnr) throws Exception;
    void deleteBookingFromBooking(int bookingId) throws Exception ;
    int generateBookingId() throws Exception;
    int generatePnr() throws Exception;
    String[] getBookingFromBooking(int bookingId) throws Exception ;
    String[] getBookingFromPassengers(String pnr) throws Exception ;
}
