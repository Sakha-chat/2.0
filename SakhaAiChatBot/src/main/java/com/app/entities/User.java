package com.app.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    int userId;
	    String username;
	    String userEmail;
	    String password;
	    String phoneNumber;
	    public int getUserId() {
	        return userId;
	    }
	    public void setUserId(int userId) {
	        this.userId = userId;
	    }
	    public String getUsername() {
	        return username;
	    }
	    public void setUsername(String username) {
	        this.username = username;
	    }
	    public String getUserEmail() {
	        return userEmail;
	    }
	    public void setUserEmail(String userEmail) {
	        this.userEmail = userEmail;
	    }
	    public String getPassword() {
	        return password;
	    }
	    public void setPassword(String password) {
	        this.password = password;
	    }
	    public String getPhoneNumber() {
	        return phoneNumber;
	    }
	    public void setPhoneNumber(String phoneNumber) {
	        this.phoneNumber = phoneNumber;
	    }
	    @Override
	    public String toString() {
	        return "User [userId=" + userId + ", username=" + username + ", userEmail=" + userEmail + ", password="
	                + password + ", phoneNumber=" + phoneNumber + "]";
	    }
	   
}
