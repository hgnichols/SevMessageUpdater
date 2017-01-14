package com.hunternichols.message;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Tester {

	public static void main(String args[]) {
			
			String connection = "jdbc:sqlserver://HGNICHOLS\\MSSQLSERVER2012:54173;databaseName=SevMessage;user=sa;password=itcs3160";
			
			try {
				Connection conn = DriverManager.getConnection(connection);
				System.out.println("we through");
				System.out.println(conn.toString());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
}
