package org.jointheleague.modules;

import java.util.ArrayList;

import org.javacord.api.event.message.MessageCreateEvent;

import net.aksingh.owmjapis.api.APIException;

public class ConnectFour extends CustomMessageCreateListener {

	final String Start_Game = "!StartGame";
	final String move = "!Move";
	public ConnectFour(String channelName) {
		super(channelName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handle(MessageCreateEvent event) throws APIException {
		// TODO Auto-generated method stub
		if(event.getMessageContent().equals(Start_Game)) {
			HandleGame(event);
		}
	}

	private void HandleGame(MessageCreateEvent event) {
		// TODO Auto-generated method stub
		String[] RowOne = {"u", "u", "u", "u", "u", "u", "u"};
		String[] RowTwo = {"u", "u", "u", "u", "u", "u", "u"};
		String[] RowThree = {"u", "u", "u", "u", "u", "u", "u"};
		String[] RowFour = {"u", "u", "u", "u", "u", "u", "u"};
		String[] RowFive = {"u", "u", "u", "u", "u", "u", "u"};
		String[] RowSix = {"u", "u", "u", "u", "u", "u", "u"};
		
		
	}

}
