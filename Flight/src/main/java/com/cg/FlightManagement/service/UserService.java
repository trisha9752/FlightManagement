package com.cg.FlightManagement.service;


import java.util.List;

import com.cg.FlightManagement.dto.User;


public interface UserService {
	 int addUser(User u) throws Exception;
	 boolean isUser(User u) throws ArrayIndexOutOfBoundsException;
     User viewUserById(int userId) throws Exception;
	 void deleteUser(int userId) throws Exception;
	 void updateUser(int userId,User user) throws Exception;
	 boolean isAdmin(int userId) throws Exception;
}

