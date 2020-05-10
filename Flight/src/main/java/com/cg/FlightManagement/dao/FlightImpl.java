package com.cg.FlightManagement.dao;

import com.cg.FlightManagement.dto.Flight;
import com.cg.FlightManagement.exception.FlightManagementException;

import java.io.FileOutputStream;
import java.util.Properties;

public class FlightImpl implements FlightDao{
    Properties database;
    PropertyFileImpl propertyFile = new PropertyFileImpl();
    public FlightImpl() throws Exception {
        database = propertyFile.read(DatabaseLocationDao.flight);
    }
    @Override
    public void deleteFlightFromDatabase(Integer flightNumber) throws Exception{
        try {
            database.remove(flightNumber.toString());
        }catch (Exception e){
            throw new FlightManagementException("Wrong Flight Number.. ");
        }
        database.store(new FileOutputStream(DatabaseLocationDao.flight), null);
    }
    @Override
    public void addFlightToDatabase(Flight flight) throws Exception{
        /* O is no. of passengers
		Don't change the order otherwise database will get rekt*/
        database.setProperty(Integer.toString(flight.getFlightNumber())
                ,flight.getSeatCapacity()+","+flight.getCarrierName()+
                        ","+flight.getFlightModel()+","+0+","+flight.getCost());
        database.store(new FileOutputStream(DatabaseLocationDao.flight), null);
    }
    @Override
    public Flight getFlightFromDatabase(int flightNumber) throws Exception {
        String[] value = database.getProperty(Integer.toString(flightNumber)).split(",");
        Flight flight = new Flight();
        flight.setCost(Integer.parseInt(value[4]));
        flight.setFlightNumber(flightNumber);
        flight.setCarrierName(value[1]);
        flight.setSeatCapacity(Integer.parseInt(value[0]));
        flight.setFlightModel(value[2]);
        return flight;
    }
    @Override
    public int getCapacityFromDatabase(int flightNumber) throws Exception{
        try {
            String[] value = database.getProperty(Integer.toString(flightNumber)).split(",");
            return Integer.parseInt(value[0]);
        }catch (Exception e){
            throw new FlightManagementException("Invalid Flight Number");
        }
    }
    @Override
    public String getFlightModelFromDatabase(int flightNumber) throws Exception{
        try {
            String[] value = database.getProperty(Integer.toString(flightNumber)).split(",");
            return value[2];
        }catch (Exception e){
            throw new FlightManagementException("Invalid Flight Number");
        }
    }
    @Override
    public String getFlightNameFromDatabase(int flightNumber) throws Exception{
        try {
            String[] value = database.getProperty(Integer.toString(flightNumber)).split(",");
            return value[1];
        }catch (Exception e){
            throw new FlightManagementException("Invalid Flight Number");
        }
    }
    @Override
    public double getCostFromDatabase(int flightNumber) throws Exception{
        try {
            String[] value = database.getProperty(Integer.toString(flightNumber)).split(",");
            return Integer.parseInt(value[4]);
        }catch (Exception e){
            throw new FlightManagementException("Invalid Flight Number");
        }
    }
    @Override
    public int getNoOfPassengers(int flightNumber) throws Exception {
        try {
            String[] value = database.getProperty(Integer.toString(flightNumber)).split(",");
            return Integer.parseInt(value[3]);
        }catch (Exception e){
            throw new FlightManagementException("Invalid Flight Number");
        }
    }
}
