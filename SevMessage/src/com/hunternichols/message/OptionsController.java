package com.hunternichols.message;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class OptionsController {

	private final String configFileName = System.getProperty("user.home") + File.separator + "Documents"
			+ File.separator + "SevMessageConfig" + File.separator + "Options.properties";
	private final String configFileDir = System.getProperty("user.home") + File.separator + "Documents" + File.separator
			+ "SevMessageConfig";
	Properties prop;

	public OptionsController() {

		prop = loadProp();
	}

	public Properties loadProp() {
		File file = new File(configFileName);

		if (!file.exists()) {

			File dir = new File(configFileDir);

			dir.mkdirs();
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			BufferedWriter bw = null;
			FileWriter fw = null;

			try {

				fw = new FileWriter(configFileName);
				bw = new BufferedWriter(fw);
				bw.write("initBoot = true");
				bw.newLine();
				bw.write("messageFrequency = 30");
				bw.newLine();
				bw.write("refreshRate = 30");
				bw.newLine();
				bw.write("devMode=false");
			} catch (IOException e) {

				e.printStackTrace();
			} finally {
				try {

					if (bw != null)
						bw.close();

					if (fw != null)
						fw.close();
				} catch (IOException ex) {

					ex.printStackTrace();
				}
			}
		}

		Properties prop = new Properties();
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(configFileName);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			prop.load(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return prop;
	}
	
	public void saveProperties() {
		
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(configFileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.getProp().store(out, "---No Comment---");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Properties getProp() {
		return prop;
	}
	
	public void setProp(Properties prop) {
		this.prop = prop;
	}
	
	public String getConfigFileDir() {
		return configFileDir;
	}
	
	public String getConfigFileName() {
		return configFileName;
	}
	
}
