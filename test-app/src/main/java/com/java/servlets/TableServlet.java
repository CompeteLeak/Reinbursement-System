
package com.java.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.users.DummyUsers;
import com.jdbc.pojo.Bursement;
import com.jdbc.pojo.TemperPerson;
@WebServlet("/table")
public class TableServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DummyUsers service = new DummyUsers();
	private static Logger log =  Logger.getLogger(TableServlet.class);

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int counter = 4; 
		ObjectMapper mapper = new ObjectMapper();
		TemperPerson t = mapper.readValue(req.getInputStream(), TemperPerson.class);
		service.userTable(t.getUsername());

		for(Bursement obj: service.getTale() ) {

			String html = "<tr><th scope=\"row\"> "+counter+" </th><td> $" + obj.getPrice() + "</td><td>" +obj.getTickets()+ "</td><td>"+obj.getStati() +"</td></tr>";





			PrintWriter writer = resp.getWriter(); 
			resp.setContentType("text/html");
			writer.write(html); counter ++; } service.clearList(); 
	}

}

