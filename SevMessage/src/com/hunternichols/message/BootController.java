package com.hunternichols.message;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.hunternichols.database.framework.DatabaseController;

public class BootController {

	public static File f;
	public static FileChannel channel;
	public static FileLock lock;

	@SuppressWarnings("resource")
	public static void main(String args[]) {

		OptionsController oc = new OptionsController();
		DatabaseController testsConnection = DatabaseController.getDBController();
		try {

			@SuppressWarnings("unused")
			Connection conn = DriverManager.getConnection(testsConnection.buildConnectionString());
			
			oc.getProp().setProperty("offlineMode", "false");
			oc.saveProperties();
			
		} catch (SQLException e) {

			oc.getProp().setProperty("offlineMode", "true");
			oc.saveProperties();
		}

		if (!StartUp.exists()) {

			StartUp.create();
		}

		if (oc.getProp().getProperty("devMode").equals("true")) {

			DevWindow devWindow = new DevWindow();
			devWindow.frame.setVisible(true);
		} else {

			try {

				f = new File(System.getProperty("user.home") + File.separator + "Documents" + File.separator
						+ "SevMessageConfig" + File.separator + "key.lock");

				if (f.exists()) {

					f.delete();
				}

				channel = new RandomAccessFile(f, "rw").getChannel();
				lock = channel.tryLock();

				if (lock == null) {

					channel.close();
					SingleInstancePrompt sip = new SingleInstancePrompt();
					sip.setVisible(true);
					throw new RuntimeException("Only 1 instance of this program can be run at a time");
				}

				Thread shutdown = new Thread(new Runnable() {

					@Override
					public void run() {

						unlock();
					}
				});

				Runtime.getRuntime().addShutdownHook(shutdown);

				// program goes here
				if (Boolean.parseBoolean(oc.getProp().getProperty("offlineMode"))) {
					
					OfflineWindowInfo offline = new OfflineWindowInfo();
					offline.setVisible(true);
				}
				
				MessageFrequencyController messageFrequency = new MessageFrequencyController("FrequencyThread");
				messageFrequency.start();

				RefreshRateController refresh = new RefreshRateController("RefreshThread");
				refresh.start();

			} catch (IOException e) {

				throw new RuntimeException("Could not start process", e);
			}

		}
	}

	public static void unlock() {

		try {

			if (lock != null) {

				lock.release();
				channel.close();
				f.delete();
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
