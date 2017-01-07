package com.hunternichols.message;

public class MessageFrequencyController implements Runnable {

	public Thread t;
	private String threadName;

	public MessageFrequencyController(String name) {

		threadName = name;
		System.out.println("Creating " + threadName);
	}

	@Override
	public void run() {
		System.out.println("Running " + threadName);
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
		System.out.println("Starting " +  threadName );
		
		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}

}
