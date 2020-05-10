package com.cg.FlightManagement.utilities;

import com.cg.FlightManagement.dto.User;
import com.cg.FlightManagement.exception.FlightManagementException;

public class UserValidation {
	
	public void validate(User user) throws Exception {

		userNameValidation(user.getUserName());
		userPhoneValidation(user.getUserPhone());
		userPasswordValidation(user.getUserPassword());
		userEmailValidation(user.getUserEmail());
	}
	
	public static void userNameValidation(String userName) throws FlightManagementException {
		if(!userName.matches("[A-Za-z]+"))
			throw new FlightManagementException("Username can only contain whitespac and alphabet");
	}
	public static void userPhoneValidation(Long userPhone) throws FlightManagementException {
		if(userPhone.toString().length() != 10)
			throw new FlightManagementException("Enter 10 digit phone number");
	}
	public static void userPasswordValidation(String userPassword) throws FlightManagementException {
		if(!userPassword.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$"))
			throw new FlightManagementException("Password should contain 1 special character,1 digits,at least 8 characters\n and at least one lower character and one upper character");
	}
	public static void userEmailValidation(String userEmail) throws FlightManagementException{
		String pattern = "[A-Za-z]{4,20}[@]{1}[gmail]{5}[.com]{4}";
		if(!userEmail.matches(pattern))
			throw new FlightManagementException("Enter valid email id");
	}
}
