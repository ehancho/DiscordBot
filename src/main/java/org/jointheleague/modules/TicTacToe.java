package org.jointheleague.modules;

import org.javacord.api.event.message.MessageCreateEvent;

import net.aksingh.owmjapis.api.APIException;

public class TicTacToe extends CustomMessageCreateListener{

	public static final String Start_Command = "!playtic";
	
	public TicTacToe(String channelName) {
		super(channelName);
		
	}

	@Override
	public void handle(MessageCreateEvent event) throws APIException {
		// TODO Auto-generated method stub
		String thing = event.getMessageContent();
		
		if (thing.startsWith(thing)) {
			event.getChannel().sendMessage("Playing Tic-Tac-Toe");
		}
	}
	

}
