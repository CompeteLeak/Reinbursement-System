package com.java.servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.users.DummyUsers;
import com.jdbc.pojo.Bursement;
import com.jdbc.pojo.User;
//import com.revature.service.DummyUserService;
import com.jdbc.util.ConnectionFactory;

@WebServlet("/check")
public class ServletCheck extends HttpServlet {

	/**
	 * 
	 */
	private final static Logger LOGGER =  
			Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private static final long serialVersionUID = 1L;
	DummyUsers service = new DummyUsers();


	/*
	 * Use Jackson ObjectMapper to send response of all users 
	 * as a JSON string 
	 */
	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Bursement b = mapper.readValue(req.getInputStream(), Bursement.class);
		service.insertTicket(b.getUsername(), b.getPrice(), b.getTickets(), b.getStati()); 
		LOGGER.info("Ticket Inserted");










	}




}

