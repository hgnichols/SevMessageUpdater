package com.hunternichols.database.framework;

import com.hunternichols.database.dataobjects.Customer;
import com.hunternichols.database.dataobjects.Message;

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
}
