package com.hunternichols.message;

import java.awt.Rectangle;

public class MessageFrequencyController implements Runnable {

	public Thread t;
	private String threadName;

	public MessageFrequencyController(String name) {

		threadName = name;
	}

	@Override
	public void run() {
		OptionsController oc = new OptionsController();
		
		MainWindow mainWindow = new MainWindow();
		mainWindow.initWindow();

			if (oc.getProp().getProperty("initBoot").equals("true")) {
				
				if(Boolean.parseBoolean(oc.getProp().getProperty("toBePatched"))) {
					
					InstructionWindow pathNotes = new InstructionWindow();
					Rectangle frameSize= pathNotes.getBounds();
					pathNotes.setBounds(frameSize.x, frameSize.y, 461, 300);
					
					frameSize = pathNotes.txtrHelloTheLove.getBounds();
					pathNotes.txtrHelloTheLove.setBounds(frameSize.x, frameSize.y, 426, 205);
					pathNotes.txtrHelloTheLove.setText("-Misc Bug Fixes\n-Fixed patch widnow poping up every time\n-Fixed Pop-Up Message\n-*IMPORTANT* Every update resets your settings. So Please go change them!");
					pathNotes.lblNewLabel.setText("Beta Testing Version: " + oc.getProp().getProperty("version") + " Patch Notes (please read)");
					pathNotes.setVisible(true);
					
					oc.getProp().setProperty("toBePatched", "false");
					oc.saveProperties();
				} else {
					
					InstructionWindow iWindow = new InstructionWindow();
					iWindow.setVisible(true);	
				}
				
				oc.getProp().setProperty("initBoot", "false");
				oc.saveProperties();
		}
	}

	public void start() {

		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}

}
