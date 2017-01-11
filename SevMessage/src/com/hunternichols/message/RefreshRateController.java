package com.hunternichols.message;

import com.hunternichols.database.dataobjects.Update;
import com.hunternichols.database.framework.DatabaseController;

public class RefreshRateController implements Runnable {

	private Thread t;
	private String threadName;
	private DatabaseController dbc = null;
	private OptionsController oc;

	RefreshRateController(String name) {

		OptionsController oc = new OptionsController();
		if (!Boolean.parseBoolean(oc.getProp().getProperty("offlineMode"))) {

			dbc = DatabaseController.getDBController();
		}
		threadName = name;
		oc = new OptionsController();
	}

	@Override
	public void run() {
		oc = new OptionsController();
		boolean on = true;
		
		if (!Boolean.parseBoolean(oc.getProp().getProperty("offlineMode"))) {
			while (on) {
				oc = new OptionsController();

				Update checker = dbc.getUpdate();
				if (checker != null && checker.getSendMessage() == 1) {

					PopUpWindow popUp = new PopUpWindow();
					popUp.setVisible(true);
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
	}

	public void start() {

		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}

}
