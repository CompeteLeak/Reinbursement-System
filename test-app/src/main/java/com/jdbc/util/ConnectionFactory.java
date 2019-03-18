package com.jdbc.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;

import org.apache.log4j.Logger;

public class ConnectionFactory {

	//this class is used to establish connections with databse, lazy singleton design patterb
	//lazy singletion is a design pattern that calls an instance of this clss when the class in instantiated 

	//1 need driver(obj), location of url , username, password 

//	final static Logger logger = 
//			Logger.getLogger(ConnectionFactory.class); 


	private static ConnectionFactory cf = null; 

	private ConnectionFactory () {

	}

	public static synchronized ConnectionFactory getInstance() {

		if (cf == null) {
			cf = new ConnectionFactory(); 
		}
		//logger.info("Returning CF instance " + cf.getClass()); 
		return cf; 
	}

	public Connection getConnection() {
		Connection conn = null;
		Properties prop = new Properties(); 
		String filepath = "/Users/malikwhite/eclipse2-workspace/test-app/src/main/resources/db.properties";
//		String path = new File("").getAbsolutePath();  
//		logger.info(" PAth is " + path);
		

		try {
			prop.load(new FileReader(filepath));
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(
					prop.getProperty("url"),
					prop.getProperty("username"),
					prop.getProperty("pwd")); 

		} catch (FileNotFoundException e) {
			e.printStackTrace(); 
		}catch (IOException e) {
			e.printStackTrace(); 
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace(); 
		}
		catch (SQLException e) {
			e.printStackTrace(); 
		}
		return conn;

	}

}
