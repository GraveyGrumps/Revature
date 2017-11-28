package com.revature.services;

import com.revature.beans.User;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOjdbc;

public class UserService {
	private UserDAO ud = new UserDAOjdbc();
	private static UserService us = new UserService();
	private UserService() {}
	public static UserService getUserService()
	{
		return us;
	}
	
	public User login(User u)
	{
		return ud.findByUsernameAndPassword(u.getUsername(), u.getPassword());
	}
}
