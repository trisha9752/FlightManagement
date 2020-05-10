package com.cg.FlightManagement.service;

import java.util.Properties;

import com.cg.FlightManagement.dao.DatabaseLocationDao;
import com.cg.FlightManagement.dao.PropertyFileImpl;
import com.cg.FlightManagement.dao.UserImpl;
import com.cg.FlightManagement.dto.User;
import com.cg.FlightManagement.utilities.UserValidation;


public class UserServiceImpl extends UserImpl implements UserService {
	UserValidation validator = new UserValidation();
	Properties database;
	PropertyFileImpl propertyFile = new PropertyFileImpl();
	public UserServiceImpl() throws Exception{
		database = propertyFile.read(DatabaseLocationDao.user);
	}
	@Override
	public int addUser(User user) throws Exception {
		int currentUserId = this.generateUserId();
		user.setUserId(currentUserId);
		validator.validate(user);
		this.addUserToDatabase(user);
		return currentUserId;
	}

	@Override
	public boolean isUser(User user) throws ArrayIndexOutOfBoundsException {
			if (checkUserFromDatabase(user))
				return true;
			else
				throw new ArrayIndexOutOfBoundsException();
	}
	@Override
	public void deleteUser(int userId) throws Exception {
		this.deleteBookingFromDatabase(userId);
	}

	@Override
	public void updateUser(int userId,User user) throws Exception {
		this.deleteBookingFromDatabase(userId);
		this.addUser(user);
	}
	
	public User viewUserById(int userId) throws Exception {
		return this.getUserFromDatabase(userId);
	}

	@Override
	public boolean isAdmin(int userId) throws Exception {
		User admin = this.getUserFromDatabase(userId);
		return admin.getIsAdmin();
	}
}

