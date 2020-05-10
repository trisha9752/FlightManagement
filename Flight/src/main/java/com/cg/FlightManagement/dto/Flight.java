package com.cg.FlightManagement.dto;

public class Flight {
	private int flightNumber;
	private String flightModel;
	private String carrierName;
	private int seatCapacity;
	private int cost;
	public int getCost(){
		return cost;
	}
	public void setCost(int cost){
		this.cost = cost;
	}
	public int getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getFlightModel() {
		return flightModel;
	}
	public void setFlightModel(String flightModel) {
		this.flightModel = flightModel;
	}
	public String getCarrierName() {
		return carrierName;
	}
	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}
	public int getSeatCapacity() {
		return seatCapacity;
	}
	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}
	
	
}

