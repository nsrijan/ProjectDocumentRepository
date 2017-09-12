package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.UserDao;
import com.project.model.User;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	public void addUser(User user){
		userDao.addUser(user);
	}
	
	public User validateUser(User user){
		System.out.println("UserService=====>>>"+user);
		return userDao.validateUser(user);
	}
}
