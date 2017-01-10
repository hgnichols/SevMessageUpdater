package com.hunternichols.message;

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

			InstructionWindow iWindow = new InstructionWindow();
			iWindow.setVisible(true);

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
