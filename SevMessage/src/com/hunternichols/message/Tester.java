package com.hunternichols.message;

import java.awt.Rectangle;

public class Tester {

	public static void main(String args[]) {
		OptionsController oc = new OptionsController();
		InstructionWindow pathNotes = new InstructionWindow();
		Rectangle frameSize= pathNotes.getBounds();
		pathNotes.setBounds(frameSize.x, frameSize.y, 461, 300);
		
		frameSize = pathNotes.txtrHelloTheLove.getBounds();
		pathNotes.txtrHelloTheLove.setBounds(frameSize.x, frameSize.y, 400, 200);
		pathNotes.txtrHelloTheLove.setText("-Misc Bug Fixes\n-Moved offlineMBank Refresh Button into options window\n-Added Patch Notes Window :)");
		pathNotes.lblNewLabel.setText("Beta Testing Version: " + oc.getProp().getProperty("version") + " Patch Notes (please read)");
		pathNotes.setVisible(true);
		
	}
}
