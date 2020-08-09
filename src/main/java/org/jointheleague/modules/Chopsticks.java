package org.jointheleague.modules;

import java.util.Optional;

import org.javacord.api.entity.user.User;
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

			event.getChannel().sendMessage("Use " + add_command + "to play(ex: " + add_command + " right left)");
			HandlePlay(event);
			playing = true;
		} else if (event.getMessageContent().startsWith(add_command) && playing == true) {
			event.getChannel().sendMessage("test");
			String hand = event.getMessageContent().substring(11);
			HandleAdd(hand, event);
		}
	}

	private void HandleAdd(String hand, MessageCreateEvent event) {
		// TODO Auto-generated method stub
		String[] str = hand.split(" ");
		if (str[0].equals("right")) {
			if (str[1].equals("right")) {

				botHand2 += hand2;
			} else if (str[1].equals("left")) {
				botHand2 += hand1;

			}
		} else if (str[0].equals("left")) {
			if (str[1].equals("right")) {
				botHand1 += hand2;
			} else if (str[1].equals("left")) {
				botHand1 += hand1;

			}
		} else {
			event.getChannel().sendMessage("invalid message");
		}
		event.getChannel().sendMessage("Bot:   " + botHand1 + "     " + botHand2);
		event.getChannel().sendMessage("You:   " + hand1 + "     " + hand2);
	}

	private void HandlePlay(MessageCreateEvent event) {
		// TODO Auto-generated method stub
		event.getChannel().sendMessage("Bot:   " + botHand1 + "     " + botHand2);
		event.getChannel().sendMessage("You:   " + hand1 + "     " + hand2);

	}

}
