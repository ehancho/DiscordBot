package org.jointheleague.modules;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.javacord.api.event.message.MessageCreateEvent;

import net.aksingh.owmjapis.api.APIException;

public class ListMakerMessageListener extends CustomMessageCreateListener{

	static final String Show_List_Command = "!ShowList";
	static final String Remove_Command = "!removeFromList";
	static final String Add_Command = "!addToList";
	static final String Commands = "!commands";
	
	public ListMakerMessageListener(String channelName) {
		super(channelName);
		
	}

	@Override
	public void handle(MessageCreateEvent event) throws APIException {
		if (event.getMessageContent().equals(Show_List_Command)) {
			HandleShowList(event);
			
		}else if (event.getMessageContent().contains(Remove_Command)) {
			HandleRemove(event);
		
		}else if (event.getMessageContent().contains(Add_Command)) {
			String test = event.getMessageContent().substring(10);
			HandleAdd(test, event);
			
		}else if (event.getMessageContent().equals(Commands)) {
			event.getChannel().sendMessage("The commands are:\n" + 
					Show_List_Command + ":Shows the created list \n" +
					Remove_Command + ":Removes task from top of the list \n" + 
					Add_Command + ":Adds typed string to bottom of the list");
			
		}
	}

	private void HandleAdd(String test, MessageCreateEvent event) {
	try {
		
		FileWriter fw = new FileWriter("src/main/java/org.jointheleague.modules/list.txt", true);
		fw.write(test + "\n");
		fw.close();
	} catch (Exception e) {
	
	}
		
	event.getChannel().sendMessage("Item added");
	}

	private void HandleRemove(MessageCreateEvent event) {
		try {
			String remove = event.getMessageContent().substring(15);
			FileWriter write = new FileWriter("src/main/java/org.jointheleague.modules/temp.txt", true);
			BufferedReader read = new BufferedReader(new FileReader("src/main/java/org.jointheleague.modules/list.txt"));
			String line = read.readLine();
			while (line!=null && remove != line) {
				write.write(line + "\n");
				}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void HandleShowList(MessageCreateEvent event) {
		try {
			String test = "";
			BufferedReader br = new BufferedReader(new FileReader("src/main/java/org.jointheleague.modules/list.txt"));
			String stuff = br.readLine();
			while (stuff!=null) {
			test += br.readLine()+ "\n";
			}
		event.getChannel().sendMessage(test);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
