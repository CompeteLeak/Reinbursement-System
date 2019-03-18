package com.java.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebServlet("*.view")
public class LoadViewServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * This servlet will follow the Front Controller
	 * design pattern (one servlet handling all requests
	 * and dispatching requests to appropriate 
	 * helper methods and/or classes) * to an extent 
	 * we will not send _every_ request here, only those
	 * with the suffix .view
	 * 
	 * We will name our partial html pages appropriately
	 * so that we will, for example, forward login.html
	 * along as a response to a request addressed to 
	 * login.view
	 */
	private static Logger log  = Logger.getLogger(LoadViewServlet.class);
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException {

		req.getRequestDispatcher("login.html")
		.forward(req, resp); 
	}
}