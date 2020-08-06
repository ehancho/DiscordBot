package org.jointheleague.modules;

import org.javacord.api.event.message.MessageCreateEvent;

import net.aksingh.owmjapis.api.APIException;

public class Chopsticks extends CustomMessageCreateListener {

	static final String test_command = "!PlaySticks";
	static final String add_command = "!addSticks";
	String hand1 = "I";
	String hand2 = "I";
	String botHand1 = "I";
	String botHand2 = "I";
	Boolean playing = false;
	public Chopsticks(String channelName) {
		super(channelName);
	}

	@Override
	public void handle(MessageCreateEvent event) throws APIException {
		// TODO Auto-generated method stub
		if (event.getMessageContent().equals(test_command)) {
			HandlePlay(event);
			playing = true;
		}
		if(playing==true && event.getMessageContent().contains(add_command)) {
			String hand = event.getMessageContent().substring(11);
			HandleAdd(hand, event);
		}
	}

	private void HandleAdd(String hand, MessageCreateEvent event) {
		// TODO Auto-generated method stub
		if (hand.equals("right")) {
			botHand2 += hand2;
			event.getChannel().sendMessage("Bot:   " + botHand1 + "     " + botHand2);
			event.getChannel().sendMessage("You:   " + hand1 + "     " + hand2);

		}else if (hand.equals("left")) {
			botHand1 += hand2;
			event.getChannel().sendMessage("Bot:   " + botHand1 + "     " + botHand2);
			event.getChannel().sendMessage("You:   " + hand1 + "     " + hand2);


		}else {
			event.getChannel().sendMessage("invalid message");
		}
	}

	private void HandlePlay(MessageCreateEvent event) {
		// TODO Auto-generated method stub
		event.getChannel().sendMessage("When using !addSticks to play, type in which of the bot's hands you want to hit. Afterwards, in the same message type which hand you want to hit the bot's with. (ex: !addSticks right left)");
		event.getChannel().sendMessage("Bot:   " + botHand1 + "     " + botHand2);
		event.getChannel().sendMessage("You:   " + hand1 + "     " + hand2);

	}

}
