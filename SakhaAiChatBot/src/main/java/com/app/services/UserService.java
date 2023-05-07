package com.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.dao.UserDao;
import com.app.entities.User;

@Component
public class UserService {

	@Autowired
	UserDao userDao;
	public User saveUser(User saveUser)
	{
		return userDao.saveUser(saveUser);
	}
	
	public User getUserByEmailAndPassword(String userEmail,String password)
	{
		return userDao.getUserByEmailAndPassword(userEmail, password);
	}
	
	
}

