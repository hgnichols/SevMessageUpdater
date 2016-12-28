package com.hunternichols.database.framework;

public interface DatabaseConstants {
	//STORED PROCEDURE NAMES
	public static final String SP_GET_CAR_BY_ID = "procGetCarByID";
	public static final String SP_GET_CUSTOMER_BY_ID = "procGetCustomerByID";
	public static final String SP_ADD_CUSTOMER = "procAddCustomer";
	public static final String SP_DELETE_CUSTOMER = "procDeleteCustomer";
	public static final String SP_UPDATE_CUSTOMER = "procUpdateCustomer";
	public static final String SP_GET_CARS_BY_PRICE_RANGE = "procGetCarsByPriceRange";
	public static final String SP_ADD_SERVICE = "procAddService";
	public static final String SP_UPDATE_SERVICE = "procUpdateService";
	public static final String SP_DELETE_SERVICE = "procDeleteService";
	public static final String SP_GET_SERVICE_BY_SERVICE_ID = "procGetServiceByServiceID";
	public static final String SP_GET_MESSAGE_BY_ID = "procGetMessageByID";
	public static final String SP_GET_NUMBER_OF_MESSAGES = "procGetNumberOfMessages";
	public static final String SP_ADD_MESSAGE = "procAddMessage";
	public static final String SP_UPDATE_UPDATES = "procUpdateUpdates";
	
	//COLUMN NAMES
	public static final String COLUMN_VEHICLE_ID = "VehicleID";
	public static final String COLUMN_CUSTOMER_ID = "ID";
	public static final String COLUMN_CUSTOMER_FIRST_NAME = "FirstName";
	public static final String COLUMN_CUSTOMER_LAST_NAME = "LastName";
	public static final String COLUMN_SERVICE_ID = "ServiceID";
	public static final String COLUMN_SERVICE_NAME = "ServiceName";
	public static final String COLUMN_SERVICE_ALLOTTED_TIME = "AllottedTime";
	public static final String COLUMN_SERVICE_COST = "Cost";
	public static final String COLUMN_MESSAGEBANK_NUMBER = "Number";
	public static final String COLUMN_MESSAGEBANK_MESSAGE = "Message";
	public static final String COLUMN_UPDATES_SEND_MESSAGE = "SendMessage";
	public static final String COLUMN_UPDATES_UPDATE_MESSAGES = "UpdateMessages";
	public static final String COLUMN_UPDATES_HEADING_UPDATE = "HeadingUpdate";
	
	//PARAMETER NAMES
	public static final String PARAM_LOW_VALUE = "LowVal";
	public static final String PARAM_HIGH_VALUE = "HighVal";
}
