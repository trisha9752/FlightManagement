package com.cg.FlightManagement.service;

import java.util.List;

import com.cg.FlightManagement.dto.Flight;

public interface FlightService {
	public int getNoOfPassengers(int flightNumber) throws Exception;
	public double getCostFromDatabase(int flightNumber) throws Exception;
	public void addFlight(Flight flight) throws Exception;
	public void modifyFlight(Flight flight) throws Exception;
	public Flight viewFlightByNum(int fNo) throws Exception;
	public void deleteFlight(int fNo) throws Exception;
	public int getCapacityFromDatabase(int flightNumber) throws Exception;
	public String getFlightModelFromDatabase(int flightNumber) throws Exception;
	public String getFlightNameFromDatabase(int flightNumber) throws Exception;
}
