package com.hunternichols.database.dataobjects;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import com.hunternichols.database.framework.DatabaseController;
import com.hunternichols.message.OptionsController;

/**
 * This is the message object for the Message SQL table. Should be used when
 * calling proc's from the SQL DB for anything in the Message table.
 * 
 * @author Hunter Nichols
 *
 */
public class Message {

	private int number;
	private String message;
	public DatabaseController dbc = null;

	/**
	 * Default constructor (should not be used)
	 */
	public Message() {

		number = 1;
		message = "Message Not Initialized";
	}

	/**
	 * Constructor, for the Message object, initializes everything to required
	 * passed in values. Object should only be created if all of this
	 * information is present.
	 * 
	 * @param aNumber
	 *            The number representing the number the message is in the SQL
	 *            table
	 * @param aMessage
	 *            The actual message in String format
	 */
	public Message(int aNumber, String aMessage) {

		number = aNumber;
		message = aMessage;
	}

	/**
	 * Sets the message (max 250 characters)
	 * 
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Sets the number of the message in the SQL table
	 * 
	 * @param number
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * Getter for the message
	 * @return message The actual message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Getter for the number of the message in the SQL table
	 * @return
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * Gets a random message from the SQL table Messages and returns the Message object with the information from the DB.
	 * Has offline handling, where if online it creates the offline message bank with no messages.
	 * @return message The message object with the information from the DB
	 */
	public String getRandomMessage() {
		OptionsController oc = new OptionsController();
		//offline handling
		if (!Boolean.parseBoolean(oc.getProp().getProperty("offlineMode"))) {

			dbc = DatabaseController.getDBController();
		}

		String message = null;
		int count = -1;

		if (!Boolean.parseBoolean(oc.getProp().getProperty("offlineMode"))) {

			if (dbc.getMessPoolSeed().getEnding().equals("end")) {
				//gets the total number of messages in the message bank
				count = dbc.getNumberOfMessages().getNumber();
			} else {

				count = Integer.parseInt(dbc.getMessPoolSeed().getEnding());
			}

			Random rand = new Random();

			int randNum = rand.nextInt((count - dbc.getMessPoolSeed().getStart()) + 1)
					+ dbc.getMessPoolSeed().getStart();

			message = dbc.getMessageByID(Integer.toString(randNum)).getMessage();
		} else {

			FileInputStream fs = null;
			String array[] = null;
			Random rand = new Random();
			int randomNumber;

			try {
				fs = new FileInputStream(System.getProperty("user.home") + File.separator + "Documents" + File.separator
						+ "SevMessageConfig" + File.separator + "offlineMessageBank.txt");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(fs));
			try {
				array = br.readLine().split("¥");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			randomNumber = rand.nextInt(array.length);

			message = array[randomNumber];
		}

		return message;
	}

	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append("Number:\t");
		buf.append(getNumber());
		buf.append("\nMessage:\t");
		buf.append(getMessage());
		return buf.toString();
	}
}
