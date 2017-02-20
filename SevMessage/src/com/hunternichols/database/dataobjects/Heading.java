package com.hunternichols.database.dataobjects;

/**
 * This class serves as the data object for the heading table in the SQL DB,
 * SevMessage
 * 
 * @author Hunter Nichols
 *
 */
public class Heading {

	private int ID;
	private String heading;

	/**
	 * Constructor, for the Heading object, initializes everything to required
	 * passed in values. Object should only be created if all of this
	 * information is present.
	 * 
	 * @param aHeading - The heading for the heading in the main window
	 */
	public Heading(String aHeading) {

		ID = 1;
		heading = aHeading;
	}

	/**
	 * Sets the ID field to a predefined ID (ID should always be 1).
	 * 
	 * @param iD
	 *            The ID for the row of the Heading table in the SQL DB, (should
	 *            always be 1).
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * Sets the heading by passing in a String (50 characters max).
	 * 
	 * @param heading
	 *            The heading message for the main window.
	 */
	public void setHeading(String heading) {
		this.heading = heading;
	}

	/**
	 * Getter for the ID (should always be 1).
	 * 
	 * @return ID The ID of the row for the Heading Table in the SQL DB.
	 */
	public int getID() {
		return ID;
	}

	/**
	 * Gets the heading field
	 * 
	 * @return heading, the heading message for the main window.
	 */
	public String getHeading() {
		return heading;
	}

	/**
	 * To String method for debugging purposes. Prints out all parts of the
	 * object.
	 */
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append("ID:\t");
		buf.append(getID());
		buf.append("\nHeading Message:\t");
		buf.append(getHeading());
		return buf.toString();
	}
}
