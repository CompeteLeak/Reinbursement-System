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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.users.DummyUsers;
import com.jdbc.pojo.User; 
//import com.revature.service.DummyUserService;
import com.jdbc.util.ConnectionFactory;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

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
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		List<User> users = service.getAllUser();

		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(users);

		PrintWriter writer = resp.getWriter();
		resp.setContentType("application/json");
		writer.write(json);
	}


	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		User u = mapper.readValue(req.getInputStream(), User.class);

		if(service.getByUsername(u.getUsername())==null){

			service.addUser(u);

			service.insertUser( u.getUsername(),u.getPassword()); 
			resp.setStatus(201);
			doGet(req, resp);

		}
		else{
			resp.setStatus(409);
		}



	}


}


