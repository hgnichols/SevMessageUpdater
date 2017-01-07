package com.hunternichols.message;

public class BootController {

	public static void main(String args[]) {

		boolean on = true;
		OptionsController oc = new OptionsController();

		if (oc.getProp().getProperty("devMode").equals("true")) {

			DevWindow devWindow = new DevWindow();
			devWindow.frame.setVisible(true);
		} else {

			while (on) {

				MessageFrequencyController messageFrequency = new MessageFrequencyController("FrequencyThread");
				messageFrequency.start();
				
				RefreshRateController refresh = new RefreshRateController("RefreshThread");
				refresh.start();
				
				try {
					Thread.sleep(Long.parseLong(oc.getProp().getProperty("messageFrequency").trim()) * 60000);
				} catch (NumberFormatException | InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
