package com.hunternichols.database.dataobjects;

import java.util.Random;

import com.hunternichols.database.framework.DatabaseController;

public class Message {

	private int number;
	private String message;
	
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
		
		DatabaseController dbc = DatabaseController.getDBController();
		String message = null;
		int count;
		
		if(dbc.getMessPoolSeed().getEnding().equals("end")) {
			
			count = dbc.getNumberOfMessages().getNumber();
		} else {
			
			count = Integer.parseInt(dbc.getMessPoolSeed().getEnding());
		}
	
		Random rand = new Random();
		int randNum = rand.nextInt(count) + dbc.getMessPoolSeed().getStart();
		
		message = dbc.getMessageByID(Integer.toString(randNum)).getMessage();
		
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
