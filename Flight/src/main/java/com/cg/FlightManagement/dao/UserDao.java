package com.cg.FlightManagement.dao;

import com.cg.FlightManagement.dto.User;

public interface UserDao {
    public int generateUserId() throws Exception;

    public void addUserToDatabase(User user) throws Exception;

    public boolean checkUserFromDatabase(User user) throws Exception;

    public void deleteBookingFromDatabase(Integer userId) throws Exception;

    User getUserFromDatabase(int userId) throws Exception;
}
