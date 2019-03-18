
package com.java.servlets;




import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.users.DummyUsers;
import com.jdbc.pojo.IdTemper;

@WebServlet("/id")
public class IdServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DummyUsers service = new DummyUsers();
	private static Logger log =  Logger.getLogger(TableServlet.class);

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		ObjectMapper mapper = new ObjectMapper();
		IdTemper i = mapper.readValue(req.getInputStream(), IdTemper.class);
		System.out.print(i.getID()); 
		System.out.print(i.getStati()); 
		service.trackTick(i.getID(), i.getStati());


	}

}

