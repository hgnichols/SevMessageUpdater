package com.hunternichols.database.framework;
import java.sql.*;
import java.util.ArrayList;

import com.hunternichols.database.dataobjects.*;

public class DatabaseController implements DatabaseConstants{
	/** VARIABLE DECLARATIONS *************************/
	private Connection dbConnection = null;
	private String userName = null;
	private String password = null;
	private String databaseName = null;
	private String databaseServerURL = null;
	private String driverClass = null;
	private String portNumber = null;
	private static DatabaseController DBController = null;
	private ObjectBuilder objectBuilder = null;
	private DatabaseMetaData dbMetaData = null;

	/** GETTERS AND SETTERS *************************/
	private ObjectBuilder  getObjectBuilder(){
		if (objectBuilder == null){
			objectBuilder = ObjectBuilder.getObjectBuilder(); 
		}
		return objectBuilder;
	}
	private Connection getDbConnection() {
		if (dbConnection == null){
			dbConnection = createDatabaseConnection();
		}
		return dbConnection;
	}
	private String getUserName() {
		if (userName == null){
			userName = "sa";
		}
		return userName;
	}
	private String getPassword() {
		if (password == null){
			password = "itcs3160";
		}
		return password;
	}
	public String getDatabaseName() {
		if (databaseName == null){
			databaseName = "AutoDealer";
		}
		return databaseName;
	}
	private String getDatabaseServerURL() {
		if (databaseServerURL == null){
			databaseServerURL = "localhost";
		}
		return databaseServerURL;
	}
	private String getDriverClass() {
		if (driverClass == null){
			driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		}
		return driverClass;
	}
	private String getPortNumber() {
		if (portNumber == null){
			portNumber = "54173";
		}
		return portNumber;
	}
	public void resetDbConnection() {
		this.dbConnection = null;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}
	public void setDatabaseServerURL(String databaseServerURL) {
		this.databaseServerURL = databaseServerURL;
	}
	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}
	public void setPortNumber(String portNumber) {
		this.portNumber = portNumber;
	}
	public static DatabaseController getDBController() {
		if (DBController == null){
			DBController = new DatabaseController();
		}
		return DBController;
	}
	private DatabaseMetaData getDBMetaData(){
		try {
			dbMetaData = getDbConnection().getMetaData();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return dbMetaData;
	}
	
	/** CONSTRUCTORS *************************/
	private DatabaseController(){
		/**
		 * This constructor is defined as private so no one 
		 * is able to create a new instance
		 * of this class.  The static method getDBController() 
		 * should be used instead.  This
		 * will ensure all classes share the same instance of 
		 * the database controller.
		 */
	}

	/** DATABASE CONNECTION CODE **********************/
	private Connection createDatabaseConnection() {
		Connection conn = null;
		String connectString = buildConnectionString();
		//First, we make sure the Driver exists
		try {
			Class.forName(getDriverClass());
		} catch (java.lang.ClassNotFoundException e) {
			StringBuffer buf = new StringBuffer();
			buf.append("No driver class found for: ");
			buf.append(getDriverClass());
			System.out.println(buf.toString());
			System.exit(0);
		}
		//Driver class exists, now try to open the connection
		try {
			conn = DriverManager.getConnection(connectString);
		} catch (SQLException e) {
			StringBuffer buf = new StringBuffer();
			buf.append("There was a problem with the following connection string: ");
			buf.append(connectString);
			buf.append("\n\nHere is the exceptio:\n");
			buf.append(e.toString());
			System.out.println(buf.toString());
			System.exit(0);
		}
		return conn;
	}
	private String buildConnectionString(){
		/**
		 * Builds a connection string from the component pieces provided in this class.
		 */
		StringBuffer buf = new StringBuffer();
		buf.append("jdbc:sqlserver://");
		buf.append(getDatabaseServerURL());
		buf.append(":");
		buf.append(getPortNumber());
		buf.append(";databaseName=");
		buf.append(getDatabaseName());
		buf.append(";user=");
		buf.append(getUserName());
		buf.append(";password=");
		buf.append(getPassword());
		return buf.toString();
	}

	/** UTILITIES   ******************************************/
	public ArrayList<String> getDatabaseNames(){
		/**
		 * This method gets a list of all the databases on the server owned by dbo
		 */
	    ArrayList<String> databases = new ArrayList<String>();
		ResultSet res;
		try {
			res = getDBMetaData().getCatalogs();
		    while (res.next()) {
		    	databases.add(res.getString("TABLE_CAT"));
			}
			res.close();
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return databases;
}
	public ArrayList<String> getTableNames(){
		/**
		 * This method gets a list of all tables in the currently active database
		 */
		ArrayList<String> tables = new ArrayList<String>();
		DatabaseMetaData dbmd = getDBMetaData();
		if (dbmd != null){
			try {
				ResultSet rs = dbmd.getTables(null, null, "%", null);
				while(rs.next()){
					if (rs.getString(2).equals("dbo")){
						tables.add(rs.getString(3));
					}
				}
			} catch (SQLException e) {
				System.out.println(e);
				e.printStackTrace();
			}
		}
		return tables;
	}
	public void printResultSet(ResultSet rs){
		/**
		 * This method just prints the contents of a ResultSet
		 * to the output console.
		 */
		try{
			boolean columnHeadingsPrinted = false;
			while (rs.next()){
				if(! columnHeadingsPrinted){
					//print the table's column headings
					for(int i=1; i<=rs.getMetaData().getColumnCount(); i++){
						System.out.print(rs.getMetaData().getColumnLabel(i));
						System.out.print(":\t");
					}
					System.out.println();
					columnHeadingsPrinted = true;
				}
				//now print a row of data	
				for(int i=1; i<=rs.getMetaData().getColumnCount(); i++){
					System.out.print(rs.getString(i));
					System.out.print("\t");
				}
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void printQueryResults(String query) {
		/**
		 * This method attempts to execute the query string passed in
		 * and print out the results to the console.
		 */
		try {
			Statement s = getDbConnection().createStatement();
			ResultSet rs = s.executeQuery(query);
			printResultSet(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		DatabaseController dbc = DatabaseController.getDBController();
		ArrayList<String> dbNames = dbc.getDatabaseNames();
		StringBuffer buf = new StringBuffer();
		buf.append("The database server has the following databases:\n");
		for (String dbName : dbNames){
			buf.append(dbName);
			buf.append("\n");
		}
		System.out.println(buf.toString());
		ArrayList<String> tables = dbc.getTableNames();
		buf = new StringBuffer();
		buf.append("Database ");
		buf.append(dbc.getDatabaseName());
		buf.append(" has the following tables:\n");
		for (String tableName : tables){
			buf.append(tableName);
			buf.append("\n");
		}
		System.out.println(buf.toString());
		
	}
	
	/** DATA ACCESS CODE **/
	
    /**
     * DATA ACCESS CODE
     * @param query
     * @return 
     */
    public ResultSet executeQuery(String query){
		 //Executes the query passed in on the active database and returns a ResultSet
		Statement s = null;
		ResultSet rs = null;
		try {
			s = getDbConnection().createStatement();
			rs = s.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet getSalesPersonByID(String salesPersonID){
		/**
		 * Returns a ResultSet containing at most one row
		 * of data about a sales person.
		 */
		StringBuilder buf = new StringBuilder();
		buf.append("SELECT * FROM SalesPeople WHERE SalesPeople.ID =");
		buf.append(salesPersonID);
		return executeQuery(buf.toString());
	}

	public ResultSet executeStoredProcedure(String procName, ArrayList<NameValuePair> nvpList) {
		/**
		 * Calls the stored procedure passed in, sending it
		 * the parameters passed in.  Returns the resulting ResultSet 
		 */
		ResultSet rs = null;
		StringBuilder buf = new StringBuilder();
		buf.append("{ call ");
		buf.append(procName);
		buf.append("(");
		for (int i=0; i<nvpList.size(); i++){
			if (i > 0) buf.append(", ");
			buf.append("?");
		}
		buf.append(") }");
		String sql = buf.toString();
		try {
			CallableStatement cs = getDbConnection().prepareCall(sql);
			for (int i=0; i<nvpList.size(); i++){
				cs.setString( nvpList.get(i).getName(), nvpList.get(i).getValue());
			}
			rs = cs.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public void executeCUDStoredProcedure(String procName, ArrayList<NameValuePair> nvpList) {
		/**
		 * Calls the stored procedure passed in, sending it
		 * the parameters passed in.  Should only be used for stored procs that create, update,
		 * or delete records
		 */
		StringBuilder buf = new StringBuilder();
		buf.append("{ call ");
		buf.append(procName);
		buf.append("(");
		for (int i=0; i<nvpList.size(); i++){
			if (i > 0) buf.append(", ");
			buf.append("?");
		}
		buf.append(") }");
		String sql = buf.toString();
		try {
			CallableStatement cs = getDbConnection().prepareCall(sql);
			for (int i=0; i<nvpList.size(); i++){
				cs.setString( nvpList.get(i).getName(), nvpList.get(i).getValue());
			}
			cs.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public ResultSet getCarByID(String carID){
		/**
		 * Returns a ResultSet containing at most one row 
		 * of data about a car
		 */
		ResultSet rs = null;
		ArrayList<NameValuePair> nvps = new ArrayList<>();
		nvps.add(new NameValuePair(COLUMN_VEHICLE_ID, carID));
		rs = executeStoredProcedure(SP_GET_CAR_BY_ID, nvps);
		return rs;
	}
	public ResultSet getCarsByPriceRange(int lowVal, int highVal){
		/**
		 * Returns a ResultSet containing at all cars with a cost
		 * between the low and high values passed in.
		 */
		ResultSet rs = null;
		ArrayList<NameValuePair> nvps = new ArrayList<>();
		nvps.add(new NameValuePair(PARAM_LOW_VALUE, Integer.toString(lowVal)));
		nvps.add(new NameValuePair(PARAM_HIGH_VALUE, Integer.toString(highVal)));
		rs = executeStoredProcedure(SP_GET_CARS_BY_PRICE_RANGE, nvps);
		return rs;
	}
	
	public Customer getCustomerByID(String custID){
		/**
		 * Returns a Customer object for the customer ID
		 * passed in
		 */
		Customer c = null;
		ResultSet rs = null;
		ArrayList<NameValuePair> nvps = new ArrayList<>();
		nvps.add(new NameValuePair(COLUMN_CUSTOMER_ID, custID));
		rs = executeStoredProcedure(SP_GET_CUSTOMER_BY_ID, nvps);
		try {
			if (rs.next()){
				c = getObjectBuilder().createCustomer(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	
	public void updateCustomer(Customer c){
		ArrayList<NameValuePair> nvpList = new ArrayList<>();
		nvpList.add(new NameValuePair(COLUMN_CUSTOMER_ID, Integer.toString(c.getID())));
		nvpList.add(new NameValuePair(COLUMN_CUSTOMER_FIRST_NAME, c.getFirstName()));
		nvpList.add(new NameValuePair(DatabaseConstants.COLUMN_CUSTOMER_LAST_NAME, c.getLastName()));
		executeCUDStoredProcedure(SP_UPDATE_CUSTOMER, nvpList);
	}

	public void addCustomer(Customer c){
		ArrayList<NameValuePair> nvpList = new ArrayList<>();
		nvpList.add(new NameValuePair(COLUMN_CUSTOMER_ID, Integer.toString(c.getID())));
		nvpList.add(new NameValuePair(COLUMN_CUSTOMER_FIRST_NAME, c.getFirstName()));
		nvpList.add(new NameValuePair(DatabaseConstants.COLUMN_CUSTOMER_LAST_NAME, c.getLastName()));
		executeCUDStoredProcedure(SP_ADD_CUSTOMER, nvpList);
	}

	public void deleteCustomer(Customer c){
		ArrayList<NameValuePair> nvpList = new ArrayList<>();
		nvpList.add(new NameValuePair(COLUMN_CUSTOMER_ID, Integer.toString(c.getID())));
		executeCUDStoredProcedure(SP_DELETE_CUSTOMER, nvpList);
	}
}
