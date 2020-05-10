package com.cg.FlightManagement.service;

import com.cg.FlightManagement.dao.FlightImpl;
import com.cg.FlightManagement.dto.Flight;

public class FlightServiceImpl extends FlightImpl implements FlightService {
	public FlightServiceImpl() throws Exception{
		super();
	}
	@Override
	public void addFlight(Flight flight) throws Exception {
		this.addFlightToDatabase(flight);
	}

	@Override
	public void modifyFlight(Flight flight) throws Exception {
		this.deleteFlightFromDatabase(flight.getFlightNumber());
		this.addFlightToDatabase(flight);
	}

	@Override
	public Flight viewFlightByNum(int flightNumber) throws Exception {
		// TODO Auto-generated method stub
			return this.getFlightFromDatabase(flightNumber);
	}

	@Override
	public void deleteFlight(int flightNumber) throws Exception {
		this.deleteFlightFromDatabase(flightNumber);
	}
}
