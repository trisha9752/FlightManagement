package com.cg.FlightManagement.dao;

import com.cg.FlightManagement.dto.Booking;
import com.cg.FlightManagement.dto.Passenger;

import java.io.FileOutputStream;
import java.util.Properties;

public class BookingImpl implements BookingDao{
    Properties database;
    PropertyFileImpl propertyFile = new PropertyFileImpl();
    @Override
    public void addBookingToBooking(Booking booking,int flightNumber,int pnrNumber) throws Exception{
        database = propertyFile.read(DatabaseLocationDao.booking);
        database.setProperty(Integer.toString(booking.getBookingId()),
                booking.getBookingDate()+","+booking.getUserId()+","+
                        flightNumber+","+pnrNumber);
        database.store(new FileOutputStream(DatabaseLocationDao.booking), null);
    }
    @Override
    public void addBookingToPassenger(Passenger passenger) throws Exception {
        database = propertyFile.read(DatabaseLocationDao.passengers);
        database.setProperty(Integer.toString(passenger.getPnrNumber()),
                passenger.getName() + "," + passenger.getAge() + "," +
                        passenger.getGender());
        database.store(new FileOutputStream(DatabaseLocationDao.passengers), null);
    }
    @Override
    public void deleteBookingFromPassengers(String pnr) throws Exception{
        database = propertyFile.read(DatabaseLocationDao.passengers);
        database.remove(pnr);
        database.store(new FileOutputStream(DatabaseLocationDao.passengers), null);
    }
    @Override
    public void deleteBookingFromBooking(int bookingId) throws Exception {
        database = propertyFile.read(DatabaseLocationDao.booking);
        database.remove(Integer.toString(bookingId));
        database.store(new FileOutputStream(DatabaseLocationDao.booking), null);
    }
    @Override
    public int generateBookingId() throws Exception{
		/* Returns total number of keys from database
		No need to plus 1 because 1st key's value is 0*/
        database = propertyFile.read(DatabaseLocationDao.booking);
        return database.stringPropertyNames().size();
    }
    @Override
    public int generatePnr() throws Exception{
		/* Returns total number of keys from database
		No need to plus 1 because 1st key's value is 0*/
        database = propertyFile.read(DatabaseLocationDao.passengers);
        return database.stringPropertyNames().size();
    }
    @Override
    public String[] getBookingFromBooking(int bookingId) throws Exception {
        database = propertyFile.read(DatabaseLocationDao.booking);
        return database.getProperty(Integer.toString(bookingId)).split(",");
    }
    @Override
    public String[] getBookingFromPassengers(String pnr) throws Exception {
        database = propertyFile.read(DatabaseLocationDao.passengers);
        return database.getProperty(pnr).split(",");
    }
}