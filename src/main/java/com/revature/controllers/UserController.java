package com.revature.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.User;
import com.revature.services.UserService;

public class UserController {
	private Logger log = Logger.getRootLogger();
	private UserService us = UserService.getUserService();
	
	
	public void processGet(HttpServletRequest request, HttpServletResponse response) {
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		log.debug(actualURL);
		if(actualURL.equals(""))
		{
			
		}
		
	}
	public void processPost(HttpServletRequest request, HttpServletResponse response) {
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		log.debug(actualURL);
		if("/users/login".equals(actualURL))
		{
			login(request,response);
			return;
			
		}
		
	}
	private void login(HttpServletRequest request, HttpServletResponse response) {
		User u = getUser(request);
			User actualUser = us.login(u);
			if(actualUser == null)
			{
				//return a 401 status code
				response.setStatus(401);
			}
			else
			{
				request.getSession().setAttribute("user", actualUser);
			}

		
	}
	private User getUser(HttpServletRequest request)
	{
		String json;
		User u = null;
		try {
			//read the body of the request into a single string
			json = request.getReader().lines().reduce((a,c) -> a + c).get();
			log.debug("request to login received");
			
			//convert the body of the request into an actual object
			ObjectMapper om = new ObjectMapper();
			u = om.readValue(json,User.class);
			log.trace("username = " + u.getUsername() + " | password = " + u.getPassword());
		} catch (IOException e) {
			log.warn("failed to parse json " + e);
		}
		return u;
	}

}
