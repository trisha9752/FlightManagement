package com.cg.FlightManagement.dto;

public class Passenger {
	private String gender;
	private int pnrNumber;
	private String passengerName ;
	private int passengerAge;
	private int passengerUIN;
	private Double luggage;
	public String getGender(){
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getPnrNumber() {
		return pnrNumber;
	}
	public void setPnrNumber(int pnrNumber) {
		this.pnrNumber = pnrNumber;
	}
	public String getName() {
		return passengerName;
	}
	public void setName(String passengerName) {
		this.passengerName = passengerName;
	}
	public int getAge() {
		return passengerAge;
	}
	public void setAge(int passengerAge) {
		this.passengerAge = passengerAge;
	}
	public int getUIN() {
		return passengerUIN;
	}
	public void setUIN(int passengerUIN) {
		this.passengerUIN = passengerUIN;
	}
	public Double getLuggage() {
		return luggage;
	}
	public void setLuggage(Double luggage) {
		this.luggage = luggage;
	} 
}

