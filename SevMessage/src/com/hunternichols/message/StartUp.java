package com.hunternichols.message;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class StartUp {

	
	private final static String inStartUpFiles = "C:/ProgramData/Microsoft/Windows/Start Menu/Programs/StartUp/SevMessageStartUp.bat";
	private final static String invisibleMaker = System.getProperty("user.home") + File.separator + "Documents" + File.separator + "SevMessageConfig" + File.separator + "invisible.vbs";

	public static boolean exists() {
		
		File aInStartUpFiles = new File(inStartUpFiles);
		File aInvisibleMaker = new File(invisibleMaker);
		return aInStartUpFiles.exists() && aInvisibleMaker.exists();
	}
	
	public static void create() {
		
		try{
		    PrintWriter writer = new PrintWriter(inStartUpFiles);
		    writer.println("wscript.exe \"C:\\Users\\Hunter\\Documents\\SevMessageConfig\\invisible.vbs\" \"C:\\Users\\Hunter\\Documents\\SevMessageConfig\\SevMessage.exe");
		    writer.close();

		    writer = new PrintWriter(invisibleMaker);
		    writer.println("CreateObject(\"Wscript.Shell\").Run \"\"\"\" & WScript.Arguments(0) & \"\"\"\", 0, False");
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
	
	//create the offline message bank here
}
