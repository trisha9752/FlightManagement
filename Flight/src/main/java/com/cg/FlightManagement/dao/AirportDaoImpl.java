package com.cg.FlightManagement.dao;
import java.util.ArrayList;
import java.util.List;

import com.cg.FlightManagement.dto.Airport;


public class AirportDaoImpl implements AirportDao {
	List<Airport>airportList=new ArrayList<Airport>();
	
	public List<Airport> viewAirport()throws Exception {
		// TODO Auto-generated method stub
		try {
			return airportList;
		}
		catch(Exception e){
			throw e;
		}
	}

	@Override
	public Airport viewAirportByCode(String airportCode) throws Exception {
		// TODO Auto-generated method stub
		try {
			Airport result = airportList.stream().filter(n -> n.getAirportCode() == airportCode).findAny().orElse(null);
			return result;
		}
		catch(Exception e) {
			throw e;
		}
	}
}
