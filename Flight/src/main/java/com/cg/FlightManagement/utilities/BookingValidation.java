package com.cg.FlightManagement.utilities;

import com.cg.FlightManagement.dto.Booking;
import com.cg.FlightManagement.dto.Flight;
import com.cg.FlightManagement.dto.Passenger;
import com.cg.FlightManagement.exception.FlightManagementException;

public class BookingValidation {
	
	public void validate(Passenger passenger) throws Exception {
		name(passenger.getName());
		gender(passenger.getGender());
	}
	private void name(String name) throws Exception{
		if (!name.matches("[a-zA-Z ]+"))
			throw new FlightManagementException("Invalid Name");
	}
	private void gender(String gender) throws FlightManagementException{
		if (!(gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female")))
			throw new FlightManagementException("Gender should be male or female");

	}

}
