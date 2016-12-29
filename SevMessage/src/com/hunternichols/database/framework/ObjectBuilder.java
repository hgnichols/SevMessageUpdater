package com.hunternichols.database.framework;

import com.hunternichols.database.dataobjects.Customer;
import com.hunternichols.database.dataobjects.Heading;
import com.hunternichols.database.dataobjects.MessPoolSeed;
import com.hunternichols.database.dataobjects.Message;
import com.hunternichols.database.dataobjects.SendMessage;
import com.hunternichols.database.dataobjects.Update;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ObjectBuilder {

	private static ObjectBuilder objBuilder = null;

	private ObjectBuilder() {

	}

	public static ObjectBuilder getObjectBuilder() {
		if (objBuilder == null) {
			objBuilder = new ObjectBuilder();
		}
		return objBuilder;
	}

	public Customer createCustomer(ResultSet rs) {
		Customer c = null;
		try {
			int custID = rs.getInt(DatabaseConstants.COLUMN_CUSTOMER_ID);
			String fName = rs.getString(DatabaseConstants.COLUMN_CUSTOMER_FIRST_NAME);
			String lName = rs.getString(DatabaseConstants.COLUMN_CUSTOMER_LAST_NAME);
			c = new Customer(custID, fName, lName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	public Message createMessage(ResultSet rs) {
		Message m = null;
		try {
			int number = rs.getInt(DatabaseConstants.COLUMN_MESSAGEBANK_NUMBER);
			String message = rs.getString(DatabaseConstants.COLUMN_MESSAGEBANK_MESSAGE);
			m = new Message(number, message);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;
	}
	
	public Update createUpdate(ResultSet rs) {
		Update u = null;
		try {
			int sendMessage = rs.getInt(DatabaseConstants.COLUMN_UPDATES_SEND_MESSAGE);
			int UpdateMessages = rs.getInt(DatabaseConstants.COLUMN_UPDATES_UPDATE_MESSAGES);
			int headingUpdate = rs.getInt(DatabaseConstants.COLUMN_UPDATES_HEADING_UPDATE);
			u = new Update(sendMessage, UpdateMessages, headingUpdate);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	
	public Heading createHeading(ResultSet rs) {
		Heading h = null;
		try {
			String headingMessage = rs.getString(DatabaseConstants.COLUMN_HEADING_HEADINGMESSAGE);
			h = new Heading(headingMessage);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return h;
	}
	
	public SendMessage createSendMessage(ResultSet rs) {
		SendMessage s = null;
		try {
			String sentMessage = rs.getString(DatabaseConstants.COLUMN_SENDMESSAGE_SENTMESSAGE);
			s = new SendMessage(sentMessage);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}
	
	public MessPoolSeed createMessPoolSeed(ResultSet rs) {
		MessPoolSeed m = null;
		try {
			int start = rs.getInt(DatabaseConstants.COLUMN_MESSPOOLSEED_START);
			String ending = rs.getString(DatabaseConstants.COLUMN_MESSPOOLSEED_ENDING);
			m = new MessPoolSeed(start, ending);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;
	}
}
