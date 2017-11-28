package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;
import org.apache.log4j.Logger;

import com.revature.controllers.UserController;

public class DispatcherServlet extends DefaultServlet{
	private UserController uc = new UserController();
	private static Logger log = Logger.getRootLogger();
	/**
	 * 
	 */
	private static final long serialVersionUID = 5264517087575469807L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		log.debug("Get request Made with URL " + actualURL);
		if (actualURL.startsWith("/static")) {
			super.doGet(request, response);
			return;
		}
		else if(actualURL.startsWith("/users/"))
		{
			uc.processGet(request,response);
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		log.debug("Get request Made with URL " + actualURL);
		
		if(actualURL.startsWith("/users/"))
		{
			uc.processPost(request,response);
		}
	}
}
