package com.hunternichols.database.dataobjects;

/**
 * Stands for Message Pool Seed (which is the starting/ending numbers that the
 * messages from the message bank pulls from) and is the object for the
 * MessPoolseed SQL table. Should be used when calling proc's from the SQL DB
 * for anything in the SendMessage table.
 * 
 * @author Hunter Nichols
 *
 */
public class MessPoolSeed {

	private int ID;
	private int start;
	private String ending;

	/**
	 * Constructor, for the MessPoolSeed object, initializes everything (except
	 * for ID) to required passed in values. Object should only be created if
	 * all of this information is present.
	 * 
	 * @param aStart
	 *            The starting number for the message ID range to start from
	 * @param aEnding
	 *            The ending number for the message ID range to end at (can be
	 *            the String 'end')
	 */
	public MessPoolSeed(int aStart, String aEnding) {

		ID = 1;
		start = aStart;
		ending = aEnding;
	}

	/**
	 * Sets the ID field to a predefined ID (ID should always be 1).
	 * 
	 * @param iD
	 *            The ID for the row of the MessPoolSeed table in the SQL DB,
	 *            (should always be 1).
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * Sets the start number for the random message picker to pull from.
	 * 
	 * @param start
	 *            Should be a number starting at 0, should not exceed total
	 *            number of messages.
	 */
	public void setStart(int start) {
		this.start = start;
	}

	/**
	 * Sets the end number for the random message picker to pull from.
	 * 
	 * @param ending
	 *            Should be a number starting at 0, should not exceed total
	 *            number of messages or be smaller then start (can also be the
	 *            String 'end' which stands for the final message).
	 */
	public void setEnding(String ending) {
		this.ending = ending;
	}

	/**
	 * Getter for the ID (should always be 1).
	 * 
	 * @return ID The ID of the row for the MessPoolSeed Table in the SQL DB.
	 */
	public int getID() {
		return ID;
	}

	/**
	 * Gets the start field
	 * 
	 * @return start the integer for the starting number for the range for the
	 *         random message picker.
	 */
	public int getStart() {
		return start;
	}

	/**
	 * Gets the end field
	 * 
	 * @return ending the last integer for the ending number for the range for
	 *         the random message picker. (can also be the String 'end')
	 */
	public String getEnding() {
		return ending;
	}

	/**
	 * To String method for debugging purposes. Prints out all parts of the
	 * object.
	 */
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append("ID:\t");
		buf.append(getID());
		buf.append("\nStart:\t");
		buf.append(getStart());
		buf.append("\nEnding:\t");
		buf.append(getEnding());
		return buf.toString();
	}
}
