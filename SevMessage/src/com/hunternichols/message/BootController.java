package com.hunternichols.message;

public class BootController {
	
	public static void main (String args[]) {
		
		OptionsController oc = new OptionsController();
		
		if(oc.getProp().getProperty("devMode").equals("true")) {
			
			DevWindow devWindow = new DevWindow();
			devWindow.frame.setVisible(true);
		} else {
			
			MainWindow mainWindow = new MainWindow();
			mainWindow.initWindow();
		}
	}
}
