package org.jointheleague.modules;

import java.io.FileWriter;

import org.javacord.api.event.message.MessageCreateEvent;

import net.aksingh.owmjapis.api.APIException;

public class ListMakerMessageListener extends CustomMessageCreateListener{

	final String New_List_Command = "!makeList";
	final String Remove_Command = "!removeFromList";
	final String Add_Command = "!addToList";
	final String Commands = "!commands";
	
	public ListMakerMessageListener(String channelName) {
		super(channelName);
		
	}

	@Override
	public void handle(MessageCreateEvent event) throws APIException {
		if (event.getMessageContent().equals(New_List_Command)) {
			HandleMakeList(event);
		}else if (event.getMessageContent().equals(Remove_Command)) {
			HandleRemove(event);
		}else if (event.getMessageContent().equals(Add_Command)) {
			HandleAdd(event);
		}else if (event.getMessageContent().equals(Commands)) {
			event.getChannel().sendMessage("The commands are:\n" + 
					New_List_Command + ":Creates a new lists \n" +
					Remove_Command + ":Removes from the list at number place directly after command(ex: !removeFromList 5) \n" + 
					Add_Command + ":Adds typed string to bottom of the list");
		}
	}

	private void HandleAdd(MessageCreateEvent event) {
	try {
		FileWriter fw = new FileWriter("src/main/java/org.jointheleague.modules/list.txt");
		fw.write("..." + "\n");
	} catch (Exception e) {
	
	}
		
	}

	private void HandleRemove(MessageCreateEvent event) {
		
		
	}

	private void HandleMakeList(MessageCreateEvent event) {
		
		
	}

}
