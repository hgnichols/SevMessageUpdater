package com.hunternichols.database.dataobjects;
/**
 * This class serves as the data object for the heading table in the SQL DB,
 * SevMessage
 * @author Hunter
 *
 */
public class Heading {

	private int ID;
	private String heading;
	
	/**
	 * 
	 * @param aHeading
	 */
	public Heading(String aHeading) {
		
		ID = 1;
		heading = aHeading;
	}
	
	/**
	 * 
	 * @param iD
	 */
	public void setID(int iD) {
		ID = iD;
	}
	
	/**
	 * 
	 * @param heading
	 */
	public void setHeading(String heading) {
		this.heading = heading;
	}
	/**
	 * 
	 * @return
	 */
	public int getID() {
		return ID;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getHeading() {
		return heading;
	}
	
	/**
	 * 
	 */
	public String toString(){
		StringBuffer buf = new StringBuffer();
		buf.append("ID:\t");
		buf.append(getID());
		buf.append("\nHeading Message:\t");
		buf.append(getHeading());
		return buf.toString();
	}
}
