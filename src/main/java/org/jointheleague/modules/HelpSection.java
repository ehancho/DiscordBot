package org.jointheleague.modules;

import java.util.HashMap;

public class HelpSection {
	String sectionName;
	HashMap<String,String> commands;
	
	HelpSection(String sectionName) {
		this.sectionName = sectionName;
	}
	
	public void addCommand(String name, String desc) {
		commands.put(name, desc);
	}
}
