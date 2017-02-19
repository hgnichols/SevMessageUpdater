package com.hunternichols.database.dataobjects;

/**
 * This is the object for the SendMessage SQL table. Should be used when calling
 * proc's from the SQL DB for anything in the SendMessage table.
 * 
 * @author Hunter Nichols
 *
 */
public class SendMessage {

	private int ID;
	private String sentMessage;

	/**
	 * Constructor, for the SendMessage object, initializes everything
	 * everything (except for ID) to required passed in values. Object should
	 * only be created if all of this information is present.
	 * 
	 * @param aSentMessage
	 *            A String that represents a message (can only be 250 characters
	 *            long);
	 */
	public SendMessage(String aSentMessage) {

		ID = 1;
		sentMessage = aSentMessage;
	}

	/**
	 * Sets the ID field to a predefined ID (ID should always be 1).
	 * 
	 * @param iD
	 *            The ID for the row of the SendMessage table in the SQL DB,
	 *            (should always be 1).
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * Sets the sentMessage field to a predefined message (max 250 characters).
	 * 
	 * @param sentMessage
	 *            Represents the message in the SendMessage table in the SQL DB
	 */
	public void setSentMessage(String sentMessage) {
		this.sentMessage = sentMessage;
	}

	/**
	 * Getter for the ID (should always be 1).
	 * 
	 * @return ID The ID of the row for the SendMessage Table in the SQL DB.
	 */
	public int getID() {
		return ID;
	}

	/**
	 * Getter for the SentMesssage field
	 * 
	 * @return sentMessage This is just the message as a String.
	 */
	public String getSentMessage() {
		return sentMessage;
	}

	/**
	 * To String method for debugging purposes. Prints out all parts of the
	 * object.
	 */
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append("ID: ");
		buf.append(getID());
		buf.append("\nSentMessage: ");
		buf.append(getSentMessage());
		return buf.toString();
	}
}
