package com.hunternichols.database.framework;

import com.hunternichols.database.dataobjects.Customer;
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

    	public Customer createCustomer(ResultSet rs){
		Customer c = null;
		try{
			int custID = rs.getInt(DatabaseConstants.COLUMN_CUSTOMER_ID);
			String fName = rs.getString(DatabaseConstants.COLUMN_CUSTOMER_FIRST_NAME);
			String lName = rs.getString(DatabaseConstants.COLUMN_CUSTOMER_LAST_NAME);
			c= new Customer(custID,  fName, lName);
		}catch (SQLException e){
			e.printStackTrace();
		}
		return c;
	}
}
