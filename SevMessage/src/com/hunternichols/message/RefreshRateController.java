package com.hunternichols.message;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.hunternichols.database.dataobjects.Update;
import com.hunternichols.database.framework.DatabaseController;

public class RefreshRateController implements Runnable {

	private Thread t;
	private String threadName;
	private DatabaseController dbc = null;
	private OptionsController oc;

	@SuppressWarnings("unused")
	RefreshRateController(String name) {

		OptionsController oc = new OptionsController();
		dbc = DatabaseController.getDBController();
		threadName = name;
		oc = new OptionsController();
	}

	@Override
	public void run() {

		oc = new OptionsController();
		boolean on = true;
		@SuppressWarnings("unused")
		Connection conn = null;
		String connectString = dbc.buildConnectionString();

		while (on) {
			
			boolean singleOffline = true;
			
			try {
				conn = DriverManager.getConnection(connectString);
				oc.getProp().setProperty("offlineMode", "false");
				oc.saveProperties();
			} catch (SQLException e) {
				StringBuffer buf = new StringBuffer();
				buf.append("There was a problem with the following connection string: ");
				buf.append(connectString);
				buf.append("\n\nHere is the exceptio:\n");
				buf.append(e.toString());
				System.out.println(buf.toString());
				oc.getProp().setProperty("offlineMode", "true");
				oc.saveProperties();
				if(singleOffline) {
					
					//execute the jar
					try {
						Runtime.getRuntime().exec("javaw -jar \"" + System.getProperty("user.home") + File.separator + "Documents" + File.separator + "SevMessageConfig" + File.separator + "NowOfflineWindow.jar\"");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}

			while (Boolean.parseBoolean(oc.getProp().getProperty("offlineMode"))) {
				oc = new OptionsController();
				dbc.resetDbConnection();
				dbc.createDatabaseConnection();
				dbc = DatabaseController.getDBController();

				try {
					Thread.sleep(Long.parseLong(oc.getProp().getProperty("refreshRate").trim()) * 1000);
				} catch (NumberFormatException | InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Refreshed offline");
				System.out.println(Boolean.parseBoolean(oc.getProp().getProperty("offlineMode")));
			}

			oc = new OptionsController();
			Update checker = null;
			try {
				
				checker = dbc.getUpdate();
			} catch(Exception e2) {
				
				oc = new OptionsController();
				oc.getProp().setProperty("offlineMode", "true");
				e2.printStackTrace();
			}			
			if (checker != null && checker.getSendMessage() == 1) {

				//put stuff to execute jar here
				try {
					Runtime.getRuntime().exec("javaw -jar \"" + System.getProperty("user.home") + File.separator + "Documents" + File.separator + "SevMessageConfig" + File.separator + "PopUpWindow.jar\"");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				checker.setSendMessage(0);
				dbc.updateUpdate(checker);

			}

			// update message is my nuke drop
			if (checker != null && checker.getUpdateMessages() == 1) {

				TheNukeWindow nukeWindow1 = new TheNukeWindow();
				nukeWindow1.setVisible(true);

			}

			try {
				Thread.sleep(Long.parseLong(oc.getProp().getProperty("refreshRate").trim()) * 1000);
			} catch (NumberFormatException | InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Refreshed");
		}
	}

	public void start() {

		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}

}
