package com.hunternichols.database.dataobjects;

/**
 * This is the object for the update SQL table. Should be used when called
 * proc's from the SQL DB for anything in the update table.
 * 
 * @author Hunter
 * 
 */
public class Update {

	private int ID;
	private int sendMessage;
	private int UpdateMessages;
	private int headingUpdate;

	/**
	 * Constructor, for the Update object initializes everything (except for ID)
	 * to required passed in values. Object should only be created if all of
	 * this information is present.
	 * 
	 * @param aSendMessage
	 *            The sendMessage column of the SQL table Updates.
	 * @param aUpdateMessages
	 *            The updateMessage column of the SQL table Update.
	 * @param aHeadingUpdate
	 *            The headingUpdate column of the SQL table Updates.
	 */
	public Update(int aSendMessage, int aUpdateMessages, int aHeadingUpdate) {

		ID = 1;
		sendMessage = aSendMessage;
		UpdateMessages = aUpdateMessages;
		headingUpdate = aHeadingUpdate;
	}

	/**
	 * Sets the ID field to a predefined ID (ID should always be 1).
	 * 
	 * @param iD
	 *            The ID for the row of the Updates table in the SQL DB, (should
	 *            always be 1).
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * Sets the sendMessage field to a predefined number (can be 0 or 1). 0
	 * would be no update and 1 would mean there is a sendMessage update. Used
	 * for the pop-up message functionality.
	 * 
	 * @param sendMessage
	 *            Should be either 0 for no update or 1 for a update.
	 */
	public void setSendMessage(int sendMessage) {
		this.sendMessage = sendMessage;
	}

	/**
	 * (Not actually used for UpdateMessages) Sets the UpdateMessages field to a
	 * predefined number (can be 0 or 1). 0 would be no update and 1 would mean
	 * there is a UpdateMessages update. Used for something else that I cannot
	 * remember at this moment.
	 * 
	 * @param updateMessages
	 *            Should be either 0 for no update or 1 for a update.
	 */
	public void setUpdateMessages(int updateMessages) {
		UpdateMessages = updateMessages;
	}

	/**
	 * (Not actually used for headingUpdate) Sets the headingUpdate field to a
	 * predefined number (can be 0 or 1). 0 would be no update and 1 would mean
	 * there is a heaindgUpdate update. Used for something else that I cannot
	 * remember at this moment.
	 * 
	 * @param headingUpdate
	 *            Should be either 0 for no update or 1 for a update.
	 */
	public void setHeadingUpdate(int headingUpdate) {
		this.headingUpdate = headingUpdate;
	}

	/**
	 * Getter for the ID (should always be 1).
	 * 
	 * @return ID The ID of the row for the Updates Table in the SevMessage DB.
	 */
	public int getID() {
		return ID;
	}

	/**
	 * Getter for the sendMessage updater (0 for no update 1 for an update).
	 * 
	 * @return sendMessage the value for weather or not the pop-up message
	 *         should appear.
	 */
	public int getSendMessage() {
		return sendMessage;
	}

	/**
	 * Getter for UpdateMessage (0 for no update 1 for an update).
	 * 
	 * @return UpdateMessages (is not for updating the message)
	 */
	public int getUpdateMessages() {
		return UpdateMessages;
	}

	/**
	 * Getter for the headingUpdate (0 for no update 1 for an update).
	 * 
	 * @return headingUpdate (is not for updating the heading).
	 */
	public int getHeadingUpdate() {
		return headingUpdate;
	}

	/**
	 * To String method for debugging purposes. Prints out all parts of the
	 * object except for ID.
	 */
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append("sendMessage: ");
		buf.append(getSendMessage());
		buf.append("\nUpdateMessages: ");
		buf.append(getUpdateMessages());
		buf.append("\nheadingUpdate: ");
		buf.append(getHeadingUpdate());
		return buf.toString();
	}
}
