package org.jointheleague.modules;

import org.javacord.api.event.message.MessageCreateEvent;

import net.aksingh.owmjapis.api.APIException;

public class EncouragingDiscourager extends CustomMessageCreateListener{

	public EncouragingDiscourager(String channelName) {
		super(channelName);
	}

	@Override
	public void handle(MessageCreateEvent event) throws APIException {
		if (event.getMessageContent().contains("my life is amazing"))
		{
			event.getChannel().sendMessage("You are a bad person. You should be sad");
		}
		else if (event.getMessageContent().contains("life sucks"))
		{
			event.getChannel().sendMessage("You should be feeling great because you are a good person. But not great");
		}
	}
	
}
