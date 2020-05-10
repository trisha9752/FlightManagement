package com.cg.FlightManagement.dao;

import com.cg.FlightManagement.dto.Flight;

public interface FlightDao {
    void deleteFlightFromDatabase(Integer flightNumber) throws Exception;

    void addFlightToDatabase(Flight flight) throws Exception;

    Flight getFlightFromDatabase(int flightNumber) throws Exception;

    int getCapacityFromDatabase(int flightNumber) throws Exception;

    String getFlightModelFromDatabase(int flightNumber) throws Exception;

    String getFlightNameFromDatabase(int flightNumber) throws Exception;

    double getCostFromDatabase(int flightNumber) throws Exception;

    int getNoOfPassengers(int flightNumber) throws Exception;
}
