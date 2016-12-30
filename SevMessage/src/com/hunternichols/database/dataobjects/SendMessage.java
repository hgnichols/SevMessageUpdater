package com.hunternichols.database.dataobjects;

public class SendMessage {

	private int ID;
	private String sentMessage;
	
	public SendMessage(String aSentMessage) {
		
		ID = 1;
		sentMessage = aSentMessage;
	}
	
	public void setID(int iD) {
		ID = iD;
	}
	
	public void setSentMessage(String sentMessage) {
		this.sentMessage = sentMessage;
	}
	
	public int getID() {
		return ID;
	}
	
	public String getSentMessage() {
		return sentMessage;
	}
	
	public String toString(){
		StringBuffer buf = new StringBuffer();
		buf.append("ID: ");
		buf.append(getID());
		buf.append("\nSentMessage: ");
		buf.append(getSentMessage());
		return buf.toString();
	}
}
