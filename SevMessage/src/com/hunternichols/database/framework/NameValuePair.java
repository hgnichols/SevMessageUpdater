package com.hunternichols.database.framework;

public class NameValuePair {
/**
 * Simple data object to hold a parameter name
 * and it's corresponding value, both as strings.
 */
	private String name = null;
	private String value = null;
	
	public String getName() {
		return name;
	}
	public String getValue() {
		return value;
	}
	public NameValuePair(String aName, String aValue){
		this.name = aName;
		this.value = aValue;
	}
}
