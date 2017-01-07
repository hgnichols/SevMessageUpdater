package com.hunternichols.message;

import com.hunternichols.database.dataobjects.Update;
import com.hunternichols.database.framework.DatabaseController;

public class RefreshRateController implements Runnable {

	private Thread t;
	private String threadName;
	private DatabaseController dbc;
	private OptionsController oc;

	RefreshRateController(String name) {

		dbc = DatabaseController.getDBController();
		threadName = name;
		oc = new OptionsController();
		System.out.println("Creating " + threadName);
	}

	@Override
	public void run() {
		System.out.println("Running " + threadName);
		boolean on = true;

		while (on) {

			Update checker = dbc.getUpdate();
			System.out.println(checker);
			if (checker.getSendMessage() == 1) {

				PopUpWindow popUp = new PopUpWindow();
				popUp.setVisible(true);
				checker.setSendMessage(0);
				dbc.updateUpdate(checker);
			}

			try {
				Thread.sleep(Long.parseLong(oc.getProp().getProperty("refreshRate").trim()) * 60000);
			} catch (NumberFormatException | InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void start() {
		System.out.println("Starting " + threadName);

		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}

}
