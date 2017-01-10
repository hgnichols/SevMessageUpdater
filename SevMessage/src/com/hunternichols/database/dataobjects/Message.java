package com.hunternichols.database.dataobjects;

import java.util.Random;

import com.hunternichols.database.framework.DatabaseController;
import com.hunternichols.message.OptionsController;

public class Message {

	private int number;
	private String message;
	public DatabaseController dbc = null;
	
	public Message() {
		
		number = 1;
		message = "Message Not Initialized";
	}
	
	public Message(int aNumber, String aMessage) {
		
		number = aNumber;
		message = aMessage;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public String getMessage() {
		return message;
	}
	
	public int getNumber() {
		return number;
	}
	
	public String getRandomMessage() {
		OptionsController oc = new OptionsController();
		if (!Boolean.parseBoolean(oc.getProp().getProperty("offlineMode"))) {

			dbc = DatabaseController.getDBController();
		} else {

		}
		String message = null;
		int count = -1;
		
		if (!Boolean.parseBoolean(oc.getProp().getProperty("offlineMode"))) {

			if(dbc.getMessPoolSeed() != null && dbc.getMessPoolSeed().getEnding().equals("end")) {
				
				count = dbc.getNumberOfMessages().getNumber();
			} else {
				
				if(count != -1) {
					
					count = Integer.parseInt(dbc.getMessPoolSeed().getEnding());
				}				
			}
		
			Random rand = new Random();
			if(count != -1) {
				
				int randNum = rand.nextInt(count) + dbc.getMessPoolSeed().getStart();
				
				message = dbc.getMessageByID(Integer.toString(randNum)).getMessage();
			}		
		} else {

		}
	
		//DONT FORGET TO FIGURE OUT WHERE THIS GOES AND FIX IT
		return message;		
	}
	public String toString(){
		StringBuffer buf = new StringBuffer();
		buf.append("Number:\t");
		buf.append(getNumber());
		buf.append("\nMessage:\t");
		buf.append(getMessage());
		return buf.toString();
	}
}
