package com.java.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.users.DummyUsers;
import com.jdbc.pojo.User; 



@WebServlet("/home")
public class HopePageServlet extends HttpServlet {

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

		ObjectMapper mapper = new ObjectMapper();
		User u = mapper.readValue(req.getInputStream(), User.class);


		String json = mapper.writeValueAsString(u.getUsername());

		PrintWriter writer = resp.getWriter();
		resp.setContentType("application/json");
		writer.write(json);
	}




	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		User u = mapper.readValue(req.getInputStream(), User.class);
		LOGGER.info(u.getUsername() + " " + u.getPassword() + " " + u.getId());

		User storedUser = service.storeOne(u.getUsername());


		if (u.getUsername().equals("ADMIN") && u.getPassword().equals("ADMIN") ) {


			LOGGER.info("Am i making it here  " + storedUser);
			resp.setContentType("text/html");
			resp.sendRedirect("admin.html");

		}

		else if(service.CheckLog(u.getUsername(), u.getPassword()) == true && u.getUsername()!= "ADMIN"){

			HttpSession session = req.getSession();
			session.setAttribute("sessionUser", u.getUsername());
			LOGGER.info("CREATED SESSION " + storedUser);
			LOGGER.info("CREATED SESSION " + u.getId());
			LOGGER.info("CREATED SESSION " + u.getUsername());
			LOGGER.info("Or am i making it here" + storedUser);
			resp.setContentType("text/html");
			resp.sendRedirect("home.html");


		}

		else if (service.CheckLog(u.getUsername(), u.getPassword()) == false) {

			req.setAttribute("alertName", "Nah Bruh");
			req.getRequestDispatcher("login.html").forward(req, resp);
			resp.setStatus(418); 
		}
		else{
			resp.setStatus(409);
			LOGGER.info("no user by this username exists");
		}



	}


}
