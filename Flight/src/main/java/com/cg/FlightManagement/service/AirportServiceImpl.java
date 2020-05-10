package com.cg.FlightManagement.service;
import java.util.ArrayList;
import java.util.List;

import com.cg.FlightManagement.dao.AirportDaoImpl;
import com.cg.FlightManagement.dto.Airport;


public class AirportServiceImpl implements AirportService {
	List<Airport>airportList=new ArrayList<Airport>();
	AirportDaoImpl adi=new AirportDaoImpl();
	
	@Override
	public List<Airport> viewAirport() throws Exception {
		// TODO Auto-generated method stub
		try {
			return adi.viewAirport() ;
		}
		catch(Exception e) {
			throw e;
		}
	}
	@Override
	public Airport viewAirportByCode(String airportCode) throws Exception {
		// TODO Auto-generated method stub
		
		try {
			return adi.viewAirportByCode(airportCode);
			}
		catch(Exception e) {
			throw e;
		}
	}	
}
