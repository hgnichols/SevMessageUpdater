package com.hunternichols.database.dataobjects;

public class Heading {

	private int ID;
	private String heading;
	
	public Heading(String aHeading) {
		
		ID = 1;
		heading = aHeading;
	}
	
	public void setID(int iD) {
		ID = iD;
	}
	
	public void setHeading(String heading) {
		this.heading = heading;
	}
	
	public int getID() {
		return ID;
	}
	
	public String getHeading() {
		return heading;
	}
	
	public String toString(){
		StringBuffer buf = new StringBuffer();
		buf.append("ID:\t");
		buf.append(getID());
		buf.append("\nHeading Message:\t");
		buf.append(getHeading());
		return buf.toString();
	}
}
