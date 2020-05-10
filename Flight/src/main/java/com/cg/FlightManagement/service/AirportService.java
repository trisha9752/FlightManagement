package com.cg.FlightManagement.service;

import java.util.List;

import com.cg.FlightManagement.dto.Airport;

public interface AirportService {
	
	public List<Airport> viewAirport() throws Exception;
	public Airport viewAirportByCode(String airportCode) throws Exception;

}
