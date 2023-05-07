package com.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.entities.User;

@Component
public class UserDao {

	@Autowired
	UserRepo userRepo;
	public User saveUser(User user)
	{
		return userRepo.save(user);
	}
	
	public User getUserByEmailAndPassword(String userEmail,String password)
	{
		User user=userRepo.findByUserEmailAndPassword(userEmail, password);
		return user;
	}
	
}
