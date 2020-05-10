package com.cg.FlightManagement.dao;

import java.util.List;

import com.cg.FlightManagement.dto.Airport;

public interface AirportDao {
	public List<Airport> viewAirport() throws Exception;
	public Airport viewAirportByCode(String airportCode) throws Exception;

}
