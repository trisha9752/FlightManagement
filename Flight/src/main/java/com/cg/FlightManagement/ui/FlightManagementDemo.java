package com.cg.FlightManagement.ui;

import java.io.FileNotFoundException;
import java.util.Scanner;
import com.cg.FlightManagement.dto.Flight;
import com.cg.FlightManagement.dto.Passenger;
import com.cg.FlightManagement.dto.User;
import com.cg.FlightManagement.exception.FlightManagementException;
import com.cg.FlightManagement.service.*;

public class FlightManagementDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner scr = new Scanner(System.in);
		int currentUserId = 0;
		boolean isUser = false;
		int bookingId = 0;

		UserServiceImpl userServices = new UserServiceImpl();
		BookingServiceImpl bookingServices = new BookingServiceImpl();
		FlightServiceImpl flightManager = new FlightServiceImpl();
		
		System.out.println("-----------FLIGHT RESERVATION SYSTEM----------");
		while(true) {
			User user = new User();
			Flight flight = new Flight();
			Passenger passenger = new Passenger();
			int input;
			input = Input.returnInt("1. User\n" + "2. Admin");
				switch (input) {
					case 1:
						switch (Input.returnInt("1. Login\n" + "2. SignUp")) {
							case 1:
								boolean repeat;
								do {
									repeat = false;
									System.out.println("---------Enter Credentials---------");
									currentUserId = Input.returnInt("Enter User Id: ");
									user.setUserId(currentUserId);
									user.setUserPassword(Input.returnStringAfterInt("Enter Password:"));
									try {
										isUser = userServices.isUser(user);
									} catch (ArrayIndexOutOfBoundsException e) {
										isUser = false;
										repeat = true;
										System.out.println("Wrong Credentials");
									}
								}while (repeat);
								break;
							case 2:
								do {
									repeat = false;
									System.out.println("---------Enter Credentials---------");
									user.setUserName(Input.returnStringAfterInt("Enter UserName:"));
									user.setUserPassword(Input.returnString("Enter Password:"));
									user.setUserEmail(Input.returnString("Enter Email"));
									user.setUserPhone(Input.returnLong("Enter Phone Number"));
									user.setIsAdmin(false);
									try {
										currentUserId = userServices.addUser(user);
									}catch (FlightManagementException e) {
										System.out.println(e.getMessage());
										repeat = true;
									}catch (Exception e){
										System.out.println("Unknown Error");
										repeat = true;
									}
									System.out.println("Your User Id is " + currentUserId);
									isUser = true;
								}while (repeat);
								break;
							default:
								System.out.println("Enter correct choice");
						}
						while (isUser) {
							System.out.println("Welcome User!!");
							switch (Input.returnInt("1. Book a Flight\n" + "2.View Booking \n" + "3. Cancel a Booking")) {
								case 1:
									boolean repeat;
									do {
										repeat = false;
										System.out.println("-------BOOKING DETAILS---------");
										passenger.setName(Input.returnStringAfterInt("Enter Passenger Name: "));
										passenger.setAge(Input.returnInt("Enter Age : "));
										passenger.setGender(Input.returnStringAfterInt("Enter Gender :"));
										flight.setFlightNumber(Input.returnInt("Enter Flight Number :"));
										try {
											bookingId = bookingServices.addBooking(
													passenger,
													currentUserId,
													flight.getFlightNumber());
										} catch (FlightManagementException e) {
											System.out.println(e.getMessage());
											repeat = true;
										}
									}while (repeat);
									System.out.println("Your Booking Id is " + bookingId);
									break;
								case 2:
									System.out.println("-------BOOKING DETAILS---------");
									do {
										repeat = false;
										try {
											String[] details = bookingServices.viewBookingById(
													Input.returnInt("Enter booking Id you wanna view: "),
													currentUserId);
											System.out.println("Booking Date: " + details[0]);
											System.out.println("User ID: " + details[1]);
											System.out.println("Flight Number: " + details[2]);
											System.out.println("PNR Number: " + details[3]);
											System.out.println("Passenger Name: " + details[4]);
											System.out.println("Age: " + details[5]);
											System.out.println("Gender: " + details[6]);
										} catch (Exception e) {
											repeat = true;
											System.out.println("Invalid booking ID or You dont have permission to view this ticket.");
										}
									}while (repeat);
									break;
								case 3:
									do {
										repeat = false;
										try {
											bookingId = Input.returnInt("Enter booking Id you wanna delete: ");
											bookingServices.deleteBooking(bookingId, currentUserId);
											System.out.println("Booking Id: " + bookingId + " is cancelled");
										} catch (Exception e) {
											repeat = true;
											System.out.println("Invalid booking ID or You dont have permission to delete this ticket.");
										}
									}while (repeat);
									break;
								default:
									System.out.println("Choose correct Option");
							}
						}
						break;
					case 2:
						switch (Input.returnInt("1. Login\n" + "2. SignUp")) {
							case 1:
								boolean repeat;
								do {
									repeat = false;
									System.out.println("---------Enter Credentials---------");
									currentUserId = Input.returnInt("Enter UserId:");
									user.setUserId(currentUserId);
									user.setUserPassword(Input.returnStringAfterInt("Enter Password:"));
									try {
										isUser = userServices.isUser(user);
									} catch (Exception e) {
										isUser = false;
										repeat = true;
										System.out.println("Wrong Credentials");
									}
								}while (repeat);
								break;
							case 2:
								do {
									repeat = false;
									System.out.println("---------Enter Credentials---------");
									user.setUserName(Input.returnStringAfterInt("Enter UserName:"));
									user.setUserPassword(Input.returnString("Enter Password:"));
									user.setUserEmail(Input.returnString("Enter Email"));
									user.setUserPhone(Input.returnLong("Enter Phone Number"));
									user.setIsAdmin(true);
									try {
										currentUserId = userServices.addUser(user);
									}catch (FlightManagementException e) {
										System.out.println(e.getMessage());
										repeat = true;
									}catch (Exception e){
										System.out.println("Unknown Error");
										repeat = true;
									}
									System.out.println("Your User Id is " + currentUserId);
									isUser = true;
								}while (repeat);
								break;
							default:
								System.out.println("Enter correct choice");
						}
						while (isUser) {
							if (userServices.isAdmin(currentUserId)) {
								System.out.println("Welcome Admin!!");
								switch (Input.returnInt(
										"1. Add a Flight\n" + "2. Schedule A Flight \n" + "3. Search A Flight\n" +
												"4. Search Schedule Flight\n" + "5. Modify Flight\n" +
												"6. View Scheduled Flight\n" + "7. Delete Flight\n"
								)) {
									case 1:
										boolean repeat;
										do {
											repeat = false;
											//Adding Flight Information in Class Flight
											flight.setFlightNumber(Input.returnInt("Enter Flight Number:"));
											flight.setSeatCapacity(Input.returnInt("Enter Seat Capacity:"));
											flight.setFlightModel(Input.returnStringAfterInt("Enter Model Number:"));
											flight.setCarrierName(Input.returnString("Enter Carrier Name:"));
											flight.setCost(Input.returnInt("Enter Cost"));
											try {
												flightManager.addFlight(flight);
											} catch (FlightManagementException e) {
												repeat = true;
												System.out.println(e.getMessage());
											} catch (FileNotFoundException e) {
												repeat = true;
												System.out.println("Internal Error");
											} catch (Exception e) {
												repeat = true;
												System.out.println("Unknown Error");
											}
										}while (repeat);
										break;
									case 2:

										break;
									case 3:
										do {
											repeat = false;
											try {
												flight = flightManager.viewFlightByNum(Input.returnInt("Enter Flight Number:"));
												System.out.println("Flight Number is " + flight.getFlightNumber());
												System.out.println("Flight Seat Capacity is " + flight.getSeatCapacity());
												System.out.println("Flight Cost is " + flight.getCost());
												System.out.println("Flight Model Number is " + flight.getFlightModel());
											} catch (FlightManagementException e) {
												repeat = true;
												System.out.println(e.getMessage());
											} catch (FileNotFoundException e) {
												repeat = true;
												System.out.println("Internal Error");
											} catch (Exception e) {
												repeat = true;
												System.out.println("Invalid Flight number");
											}
											
										}while (repeat);
										break;
									case 4:

										break;
									case 5:
										do {
											repeat = false;
											flight.setFlightNumber(Input.returnInt("Enter Flight Number You Wanna Change:"));
											flight.setSeatCapacity(Input.returnInt("Enter Seat Capacity:"));
											flight.setFlightModel(Input.returnStringAfterInt("Enter Model Number:"));
											flight.setCarrierName(Input.returnString("Enter Carrier Name:"));
											flight.setCost(Input.returnInt("Enter Cost:"));
											flight.setFlightNumber(Input.returnInt("Enter New Flight Number"));
											try {
												flightManager.modifyFlight(flight);
											} catch (FlightManagementException e) {
												repeat = true;
												System.out.println(e.getMessage());
											} catch (FileNotFoundException e) {
												repeat = true;
												System.out.println("Internal Error");
											} catch (Exception e) {
												repeat = true;
												System.out.println("Unknown Error");
											}
										}while (repeat);
										break;
									case 6:

										break;
									case 7:
										do {
											repeat = false;
											try {
												int flightNumber = Input.returnInt("Enter Flight Number:");
												flightManager.deleteFlight(flightNumber);
												System.out.println("Flight "+flightNumber+" is deleted.");
											}  catch (FlightManagementException e) {
												repeat = true;
												System.out.println(e.getMessage());
											} catch (FileNotFoundException e) {
												repeat = true;
												System.out.println("Internal Error");
											} catch (Exception e) {
												repeat = true;
												System.out.println("Unknown Error");
											}
										}while (repeat);
										break;
									default:
										System.out.println("Choose correct Option");
								}
							} else {
								System.out.println("Invalid user id or password.");
								break;
							}
						}
						break;
					default:
						System.out.println("Choose correct Option");
				}
		}
	}

}
