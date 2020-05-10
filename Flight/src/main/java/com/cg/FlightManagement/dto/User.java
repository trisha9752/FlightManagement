package com.cg.FlightManagement.dto;

public class User {
	private boolean isAdmin;
	private int userId;
	private String userName;
	private String userPassword;
	private long userPhone;
	private String userEmail;
	public void setIsAdmin(boolean isAdmin){
		this.isAdmin = isAdmin;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public void setUserPhone(long userPhone) {
		this.userPhone = userPhone;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public boolean getIsAdmin(){
		return isAdmin;
	}
	public int getUserId() {
		return userId;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public long getUserPhone() {
		return userPhone;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public String getUserName() {
		return userName;
	}
}
