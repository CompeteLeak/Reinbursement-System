package com.java.servlets;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;



@WebServlet("*.views")
public class RegisterServlet  extends HttpServlet{



	private static Logger log  = Logger.getLogger(LoadViewServlet.class);
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException {

		req.getRequestDispatcher("register.html")
		.forward(req, resp); 

	}

}
