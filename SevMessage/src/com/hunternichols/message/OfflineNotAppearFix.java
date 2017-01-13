package com.hunternichols.message;

public class OfflineNotAppearFix implements Runnable {

	private Thread t;
	private String threadName;

	public OfflineNotAppearFix(String name) {

		threadName = name;
		t = null;
	}

	@Override
	public void run() {

		OfflineWindowInfo offline = new OfflineWindowInfo();
		offline.setVisible(true);
	}

	public void start() {

		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}
}
