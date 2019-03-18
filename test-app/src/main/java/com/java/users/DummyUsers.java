package com.java.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import com.jdbc.pojo.Bursement;
import com.jdbc.pojo.User;
import com.jdbc.util.ConnectionFactory; 



public class DummyUsers implements HttpSessionBindingListener {

	private final static Logger LOGGER =  
			Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	static List<User> users = new ArrayList<User>();
	List <Bursement> role = new ArrayList<Bursement>();
	List <Bursement> admin = new ArrayList<Bursement>();
	//	static {
	//		users.add(new User("gb", "123"));
	//		users.add(new User("test", "user"));
	//		users.add(new User("Beyonce", "knowles"));
	//	}

	public List<User> getAllUser(){
		return users;
	}

	public boolean uniqueUsers(int id) {

		boolean unique = false; 
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection()){






			conn.setAutoCommit(false);


			String query = "Select * from storedUsers where userID = '" + id + "'";				
			Statement statement = conn.createStatement();

			ResultSet rs = statement.executeQuery(query);


			if(rs.next()) {



				//System.out.print("Sorry this username already exists");
				LOGGER.log(Level.INFO, " We made it here" ); 


			}

			else {
				//System.out.println("Yes username " + s + " is available.");
				unique = true; 
			}










		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		return unique; 

	}

	public boolean CheckLog(String usern, String pass) {

		boolean logged = false; 
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection()){






			conn.setAutoCommit(false);


			String query = "Select * from storedusers where username like '" + usern+ "' and password like  '" + pass + "'";				
			Statement statement = conn.createStatement();

			ResultSet rs = statement.executeQuery(query);


			if(rs.next()) {





				LOGGER.log(Level.INFO, " We made it here now" );
				logged = true; 


			}

			else {

				LOGGER.log(Level.INFO, " We made it here" ); 

			}










		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		return logged; 

	}
	
	
	public void trackTick(String ID, String stati) {

		try(Connection conn = ConnectionFactory
				.getInstance().getConnection()){






			conn.setAutoCommit(false);


//			String query = "Select * from storedusers where username like '" + usern+ "' and password like  '" + pass + "'";	
			String query = "UPDATE bursementtable SET stati ='"+ stati + "' where userid = '"+ID+"'"; 
			Statement statement = conn.createStatement();

			ResultSet rs = statement.executeQuery(query);
			LOGGER.info("Check if status updated");


			


		}
		catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void findAll(){
		//List <User> roles = new ArrayList<User>(); 

		try(Connection conn = ConnectionFactory.getInstance().getConnection()){

			String query = "Select * FROM storedUsers"; 

			Statement statement = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			ResultSet rs = statement.executeQuery(query);

			while(rs.next()) {

				User temp = new
						User(rs.getInt("Userid"), rs.getString("username"), rs.getString("password"), rs.getString("status"));
				users.add(temp); 

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();


		}
		//return users; 

	}



	//	public Bursement userTable(String username){
	//		List <Bursement> roles = new ArrayList<Bursement>(); 
	//
	//		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
	//
	//			String query = "Select * from bursementtable where username like '"+ username +"'"; 
	//
	//			Statement statement = conn.createStatement(
	//					ResultSet.TYPE_SCROLL_INSENSITIVE,
	//					ResultSet.CONCUR_READ_ONLY);
	//
	//			ResultSet rs = statement.executeQuery(query);
	//
	//			while(rs.next()) {
	//
	//				Bursement temp = new
	//				Bursement(rs.getString("username"), rs.getString("price"), rs.getString("tickets"), rs.getString("stati"));
	//				roles.add(temp); 
	//				role.add(temp); 
	//
	//			}
	//
	//		} catch (SQLException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//
	//
	//		} 
	//				return roles.stream().filter( bursement -> bursement.getUsername().equalsIgnoreCase(username))
	//						.findFirst()
	//						.orElse(null); 
	//
	//	}
	

	public void userTable(String username){
		List <Bursement> roles = new ArrayList<Bursement>(); 

		try(Connection conn = ConnectionFactory.getInstance().getConnection()){

			String query = "Select * from bursementtable where username like '"+ username +"'"; 

			Statement statement = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			ResultSet rs = statement.executeQuery(query);

			while(rs.next()) {

				Bursement temp = new
						Bursement(rs.getInt("UserId"), rs.getString("username"), rs.getString("price"), rs.getString("tickets"), rs.getString("stati"));
				roles.add(temp); 
				role.add(temp); 

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();


		} 


	}
	
	
	public void AdminTable(){
		List <Bursement> rolm = new ArrayList<Bursement>(); 

		try(Connection conn = ConnectionFactory.getInstance().getConnection()){

			String query = "select * from bursementtable"; 

			Statement statement = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			ResultSet rs = statement.executeQuery(query);

			while(rs.next()) {

				Bursement temp = new
						Bursement(rs.getInt("UserId"), rs.getString("username"), rs.getString("price"), rs.getString("tickets"), rs.getString("stati"));
				rolm.add(temp); 
				admin.add(temp); 

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();


		} 


	}



	public List <Bursement> getTale () {


		return role;
	}
	
	public List <Bursement> getHead () {


		return admin;
	}
	
public void clearAdmin() {
		
		admin.clear(); 
	}
	
	public void clearList() {
		
		role.clear(); 
	}

	public void addUser(User u) {

		users.add(u);
	}


	public User storeAll(String user, String pass){
		//List <User> roles = new ArrayList<User>(); 

		try(Connection conn = ConnectionFactory.getInstance().getConnection()){

			String query = "Select * from storedusers where username like '" + user+ "' and password like  '" + pass + "'";				

			Statement statement = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			ResultSet rs = statement.executeQuery(query);

			while(rs.next()) {

				User temp = new
						User(rs.getInt("Userid"), rs.getString("username"), rs.getString("password"), rs.getString("status"));
				users.add(temp); 

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();


		}
		return null;




	}


	public User storeOne(String user){
		//List <User> roles = new ArrayList<User>(); 

		try(Connection conn = ConnectionFactory.getInstance().getConnection()){

			String query = "Select * from storedusers where username like '" + user+ "'";				

			Statement statement = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			ResultSet rs = statement.executeQuery(query);

			while(rs.next()) {

				User temp = new
						User(rs.getInt("Userid"), rs.getString("username"), rs.getString("password"), rs.getString("status"));
				users.add(temp); 

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();


		}
		return null;




	}




	public void insertUser( String username, String password) {

		LOGGER.log(Level.INFO, " One "); 
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection()){
			//LOGGER.log(Level.INFO, " two ");





			//LOGGER.log(Level.INFO, " here " + conn);
			conn.setAutoCommit(false);
			//LOGGER.log(Level.INFO, " three ");


			String sql = " INSERT INTO storedUsers (USERNAME, Password, STATUS) VALUES ('"+ username + "', '" + password + "' ,'" + "N/A" + "') ";

			//LOGGER.log(Level.INFO, " here " + conn);
			Statement statement = conn.createStatement();
			//LOGGER.log(Level.INFO, " four ");

			ResultSet rs = statement.executeQuery(sql);
			//LOGGER.log(Level.INFO, " five ");

		}
		catch (SQLException e) {
			e.printStackTrace();
		}



	}

	public void insertTicket (String username, String price, String ticket, String status) {

		LOGGER.log(Level.INFO, " One "); 
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection()){
			//LOGGER.log(Level.INFO, " two ");





			//LOGGER.log(Level.INFO, " here " + conn);
			conn.setAutoCommit(false);
			//LOGGER.log(Level.INFO, " three ");


			//String sql = " INSERT INTO storedUsers (USERNAME, Password, STATUS) VALUES ('"+ username + "', '" + password + "' ,'" + "N/A" + "') ";
			String sql = "INSERT INTO bursementTable (userName, price, tickets, Stati )VALUES ('"+ username + "', '" +price + "', '"+ticket+ "','" + status + "' ) ";

			//LOGGER.log(Level.INFO, " here " + conn);
			Statement statement = conn.createStatement();
			//LOGGER.log(Level.INFO, " four ");

			ResultSet rs = statement.executeQuery(sql);
			//LOGGER.log(Level.INFO, " five ");

		}
		catch (SQLException e) {
			e.printStackTrace();
		}

	}




	public User getByUsername(String username){
		//want to get user by username that matches 
		//could loop through each user 
		// for(User u : users){
		// 	if(username.equalsIgnoreCase(u.getUsername())){
		// 		return u;
		// 	}
		// }

		return users.stream()
				.filter( user -> user.getUsername().equalsIgnoreCase(username))
				.findFirst()
				.orElse(null);
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub

	}


}