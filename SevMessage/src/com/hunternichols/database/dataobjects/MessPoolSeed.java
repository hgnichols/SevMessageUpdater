package com.hunternichols.database.dataobjects;

public class MessPoolSeed {

	private int ID;
	private int start;
	private String ending;
	
	public MessPoolSeed(int aStart, String aEnding) {
		
		ID = 1;
		start = aStart;
		ending = aEnding;
	}
	
	public void setID(int iD) {
		ID = iD;
	}
	
	public void setStart(int start) {
		this.start = start;
	}
	
	public void setEnding(String ending) {
		this.ending = ending;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getStart() {
		return start;
	}
	
	public String getEnding() {
		return ending;
	}
	
	public String toString(){
		StringBuffer buf = new StringBuffer();
		buf.append("ID:\t");
		buf.append(getID());
		buf.append("\nStart:\t");
		buf.append(getStart());
		buf.append("\nEnding:\t");
		buf.append(getEnding());
		return buf.toString();
	}
}
