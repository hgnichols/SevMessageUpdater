package com.hunternichols.database.dataobjects;

public class Update {

	private int ID;
	private int sendMessage;
	private int UpdateMessages;
	private int headingUpdate;
	
	public Update(int aSendMessage, int aUpdateMessages, int aHeadingUpdate) {
		
		ID = 1;
		sendMessage = aSendMessage;
		UpdateMessages = aUpdateMessages;
		headingUpdate = aHeadingUpdate;
		
	}
	
	public void setID(int iD) {
		ID = iD;
	}
	
	public void setSendMessage(int sendMessage) {
		this.sendMessage = sendMessage;
	}
	
	public void setUpdateMessages(int updateMessages) {
		UpdateMessages = updateMessages;
	}
	
	public void setHeadingUpdate(int headingUpdate) {
		this.headingUpdate = headingUpdate;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getSendMessage() {
		return sendMessage;
	}
	
	public int getUpdateMessages() {
		return UpdateMessages;
	}
	
	public int getHeadingUpdate() {
		return headingUpdate;
	}
	
	public String toString(){
		StringBuffer buf = new StringBuffer();
		buf.append("sendMessage: ");
		buf.append(getSendMessage());
		buf.append("\nUpdateMessages: ");
		buf.append(getUpdateMessages());
		buf.append("\nheadingUpdate: ");
		buf.append(getHeadingUpdate());
		return buf.toString();
	}
}
