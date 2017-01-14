package com.hunternichols.message;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import com.hunternichols.database.framework.DatabaseController;

public class StartUp {

	private final static String inStartUpFiles = "C:/ProgramData/Microsoft/Windows/Start Menu/Programs/StartUp/SevMessageStartUp.bat";
	private final static String invisibleMaker = System.getProperty("user.home") + File.separator + "Documents"
			+ File.separator + "SevMessageConfig" + File.separator + "invisible.vbs";
	private final static String offlineMessageBank = System.getProperty("user.home") + File.separator + "Documents"
			+ File.separator + "SevMessageConfig" + File.separator + "offlineMessageBank.txt";

	public static boolean exists() {

		File aInStartUpFiles = new File(inStartUpFiles);
		File aInvisibleMaker = new File(invisibleMaker);
		File aOfflineMessageBank = new File(offlineMessageBank);
		return aInStartUpFiles.exists() && aInvisibleMaker.exists() && aOfflineMessageBank.exists();
	}

	public static void create() {

		try {
			PrintWriter writer = new PrintWriter(inStartUpFiles);
			writer.println("cd C:\\Windows\\System32");
			writer.println("wscript.exe \"" + System.getProperty("user.home") + File.separator
					+ "Documents\\SevMessageConfig\\invisible.vbs\" \"" + System.getProperty("user.home")
					+ File.separator + "Documents\\SevMessageConfig\\SevMessage.exe\"");
			writer.close();

			writer = new PrintWriter(invisibleMaker);
			writer.println("CreateObject(\"Wscript.Shell\").Run \"\"\"\" & WScript.Arguments(0) & \"\"\"\", 0, False");
			writer.close();

			DatabaseController dbc = DatabaseController.getDBController();
			writer = new PrintWriter(offlineMessageBank);
			StringBuffer buf = new StringBuffer();

			OptionsController oc = new OptionsController();
			
			if (!Boolean.parseBoolean(oc.getProp().getProperty("offlineMode"))) {

				for (int x = 1; x <= dbc.getNumberOfMessages().getNumber(); x++) {

					buf.append(dbc.getMessageByID(Integer.toString(x)).getMessage());
					if(dbc.getNumberOfMessages().getNumber() != x){
						
						buf.append("¥");
					}		
				}
				writer.println(buf.toString());
			} else {
				
				 writer.println("Program never Connected to server. Therefore this file was never made. Please contact your system admin ASAP!");
			}									 
			writer.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static void delete() {

		File aInStartUpFiles = new File(inStartUpFiles);
		File aInvisibleMaker = new File(invisibleMaker);
		aInStartUpFiles.delete();
		aInvisibleMaker.delete();
	}
}
