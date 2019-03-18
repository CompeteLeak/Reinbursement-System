package com.jdbc.pojo;

public class IdTemper {
	
	
	
	private String ID; 
	private String Stati;
	
	public IdTemper() {}

	public IdTemper( String i, String stati) {
		super();
		
		this.Stati = stati;
		this.ID = i; 
	}

	public String getID() {
		return ID;
	}

	public void setID(String i) {
		this.ID = i;
	}

	public String getStati() {
		return Stati;
	}

	public void setStati(String stati) {
		this.Stati = stati;
	}
	
	
	
	
	

}
