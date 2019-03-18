
package com.java.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import com.java.users.DummyUsers;
import com.jdbc.pojo.Bursement;


@WebServlet("/admin")
public class Adminservlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DummyUsers service = new DummyUsers();
	private static Logger log =  Logger.getLogger(TableServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int counter = 4; 
		int counting = 0; 


		service.AdminTable();

		for(Bursement obj: service.getHead() ) {

			String finesse = "<div class=\"btn-group\">\n" + 
					"							<button type=\"button\" class=\"btn btn-primary dropdown-toggle\"\n" + 
					"								data-toggle=\"dropdown\">\n" + 
					"								" + obj.getStati() + " <span class=\"caret\"></span>\n" + 
					"							</button>\n" + 
					"							<ul class=\"dropdown-menu\" role=\"menu\">\n" + 
					"								<li>\n" + 
					"									<button type=\"button\" class=\"btn btn-light\" id=\"Acpt"+Integer.toString(counting) +"\"onClick=\"reply_click(this.id)\">Accept\n" + 
					"									</button>\n" + 
					"\n" + 
					"								</li>\n" + 
					"\n" + 
					"								<li>\n" + 
					"									<button type=\"button\" class=\"btn btn-light\" id=\"Deny"+Integer.toString(counting)+"\"onClick=\"reply_click1(this.id)\">Deny\n" + 
					"									</button>\n" + 
					"\n" + 
					"								</li>\n" + 
					"							</ul>\n" + 
					"						</div>"; 

			String html = "<tr><th id=\""+Integer.toString(counting)+"\"scope=\"row\"> " +obj.getUserId() + "   </th><td>" +obj.getUsername()+" </td><td> $" + obj.getPrice() + "</td><td>" +obj.getTickets()+ "</td><td>"+finesse +"</td></tr>";






			PrintWriter writer = resp.getWriter(); 
			resp.setContentType("text/html");
			writer.write(html); counter ++; counting++; } service.clearAdmin(); 
	}

}

