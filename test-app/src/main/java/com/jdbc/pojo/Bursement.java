package com.jdbc.pojo;

public class Bursement {
	
	private int UserId; 
	private String price; 
	private String username;
	private String tickets;
	private String stati;
	
	
	
	

	
	public Bursement(int UserId ,String username, String price, String tickets, String stati ) {
		super();
		
		this.UserId = UserId; 
		this.username = username;
		this.price = price;
		this.tickets = tickets;
		this.stati = stati;

	}
	
	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

public Bursement(){}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTickets() {
		return tickets;
	}
	public void setTickets(String tickets) {
		this.tickets = tickets;
	}
	public String getStati() {
		return stati;
	}
	public void setStati(String stati) {
		this.stati = stati;
	}

	@Override
	public String toString() {
		return "Bursement [price=" + price + ", username=" + username + ", tickets=" + tickets + ", stati=" + stati
				+ "]";
	} 
	
	

}
