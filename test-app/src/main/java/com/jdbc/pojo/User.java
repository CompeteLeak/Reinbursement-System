package com.jdbc.pojo;
public class User {

	private int id; 
	private String username;
	private String password;
	private String status; 
	//	private String fname; 
	//	private String lname; 
	//private String data;

	//	public String getFname() {
	//		return fname;
	//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	//	public void setFname(String fname) {
	//		this.fname = fname;
	//	}

	//	public String getLname() {
	//		return lname;
	//	}

	//	public void setLname(String lname) {
	//		this.lname = lname;
	//	}

	public User(){}

	public User(int id, String username, String password, String status ) {
		super();
		this.id = id; 
		this.username = username;
		this.password = password;
		this.status = status;
		//		this.fname = fname; 
		//		this.lname = lname; 
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	//	public String getData() {
	//		return data;
	//	}
	//	public void setData(String data) {
	//		this.data = data;
	//	}




}