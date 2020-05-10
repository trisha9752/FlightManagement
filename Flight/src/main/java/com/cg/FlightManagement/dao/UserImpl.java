package com.cg.FlightManagement.dao;

import com.cg.FlightManagement.dto.Flight;
import com.cg.FlightManagement.dto.User;

import java.io.FileOutputStream;
import java.util.Properties;

public class UserImpl implements UserDao{
    Properties database;
    PropertyFileImpl propertyFile = new PropertyFileImpl();
    public UserImpl() throws Exception {
        database = propertyFile.read(DatabaseLocationDao.user);
    }
    @Override
    public int generateUserId() throws Exception{
		/* Returns total number of keys from database
		No need to plus 1 because 1st key's value is 0*/
        return database.stringPropertyNames().size();
    }
    @Override
    public void addUserToDatabase(User user) throws Exception{
        database.setProperty(Integer.toString(user.getUserId()),
                user.getUserEmail()+","+user.getUserName()+","+
                        user.getUserPassword()+","+user.getUserPhone()+","+
                        user.getIsAdmin());
        database.store(new FileOutputStream(DatabaseLocationDao.user), null);
    }
    @Override
    // get array of string from property file via userId
    public boolean checkUserFromDatabase(User user) throws ArrayIndexOutOfBoundsException{
        String[] value = database.getProperty(Integer.toString(user.getUserId())).split(",");
			/*value[2] contains password
			also check if password matches*/
        return value[2].equals(user.getUserPassword());
    }
    @Override
    public void deleteBookingFromDatabase(Integer userId) throws Exception{
        database.remove(userId.toString());
        database.store(new FileOutputStream(DatabaseLocationDao.user), null);
    }
    @Override
    public User getUserFromDatabase(int userId) throws Exception{
        String[] value = database.getProperty(Integer.toString(userId)).split(",");
        User user = new User();
        user.setUserId(userId);
        user.setUserEmail(value[0]);
        user.setUserName(value[1]);
        user.setUserPassword(value[2]);
        user.setUserPhone(Long.parseLong(value[3]));
        user.setIsAdmin(Boolean.parseBoolean(value[4]));
        return user;
    }
}
