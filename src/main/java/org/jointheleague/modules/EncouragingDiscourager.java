package org.jointheleague.modules;

import org.javacord.api.event.message.MessageCreateEvent;

import net.aksingh.owmjapis.api.APIException;

public class EncouragingDiscourager extends CustomMessageCreateListener{

	public EncouragingDiscourager(String channelName) {
		super(channelName);
	}

	@Override
	public void handle(MessageCreateEvent event) throws APIException {
		int happiness = 0;
		String s = event.getMessageContent();
		if (s.contains("happy")) happiness++;
		if (s.toLowerCase().contains("life is amazing")) happiness++;
		if (s.toLowerCase().contains("its a good day")) happiness++;
		if (s.toLowerCase().contains("i suck")) happiness--;
		if (s.toLowerCase().contains("i am horrible")) happiness--;
		if (s.toLowerCase().contains("life is good")) happiness++;
		
		if (happiness > 0)
		{
			//good mood
			event.getChannel().sendMessage("You are a bad person. You should be sad");
		}
		else if (happiness == 0)
		{
			//ok mood
		}
		else
		{
			//bad mood
			event.getChannel().sendMessage("You should be happy because you are a good person. But not great");
		}
	}
	
}
