package com.jdbc.dao;
import  com.jdbc.pojo.User;
import com.jdbc.util.ConnectionFactory;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserRepo {
	
	
	public List <User> findAll(){
		List <User> roles = new ArrayList<User>(); 

		try(Connection conn = ConnectionFactory.getInstance().getConnection()){

			String query = "Select * FROM storedUsers"; 

			Statement statement = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			ResultSet rs = statement.executeQuery(query);

			while(rs.next()) {

				User temp = new
						User( rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("status"));
				roles.add(temp); 

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();


		}
		return roles; 

	}
	
	
	

}
