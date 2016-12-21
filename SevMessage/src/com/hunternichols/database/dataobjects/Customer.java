package com.hunternichols.database.dataobjects;

public class Customer {
	private int ID;
	private String firstName = null;
	private String lastName = null;
	
	public void setID(int iD) {
		ID = iD;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getID() {
		return ID;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	
	public Customer(int anID, String aFirstName, String aLastName){
		this.ID = anID;
		this.firstName = aFirstName;
		this.lastName = aLastName;
	}
	public String toString(){
		StringBuffer buf = new StringBuffer();
		buf.append("ID:\t");
		buf.append(getID());
		buf.append("\nFirst Name:\t");
		buf.append(getFirstName());
		buf.append("\nLast Name:\t");
		buf.append(getLastName());
		return buf.toString();
	}
}
