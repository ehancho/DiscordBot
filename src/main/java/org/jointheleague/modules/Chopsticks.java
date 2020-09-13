package org.jointheleague.modules;

import java.util.Optional;

import org.javacord.api.entity.user.User;
import org.javacord.api.event.message.MessageCreateEvent;

import net.aksingh.owmjapis.api.APIException;

public class Chopsticks extends CustomMessageCreateListener {

	static final String test_command = "!PlaySticks";
	static final String add_command = "!addSticks";
	static final String split_command = "!splitHand";
	String hand1 = "I";
	String hand2 = "I";
	String botHand1 = "I";
	String botHand2 = "I";
	Boolean playing = false;
	Boolean botTurn = false;
	Boolean eliminate = false;
	Boolean easy = false;

	public Chopsticks(String channelName) {
		super(channelName);
	}

	@Override
	public void handle(MessageCreateEvent event) throws APIException {
		// TODO Auto-generated method stub
		if (event.getMessageContent().startsWith(test_command)) {
			String level = event.getMessageContent().substring(11);
			event.getChannel().sendMessage("Use " + add_command + " to play(ex: " + add_command + " right left)");
			HandlePlay(level, event);
			playing = true;
		} else if (event.getMessageContent().startsWith(add_command) && playing == true) {
			String hand = event.getMessageContent().substring(11);
			HandleAdd(hand, event);
			botTurn = true;
		} else if (event.getMessageContent().startsWith(split_command) && playing == true) {
			String ouch = event.getMessageContent().substring(11);
			HandleSplit(ouch, event);
			botTurn = true;
		}
		if (botTurn == true) {
			if (easy = true) {
				HandleBotPlayEasy(event);
			} else {
				HandleBotPlayHard(event);
			}
			botTurn = false;
		}
		if (hand1.length() + hand2.length() == 0 && playing == true) {
			event.getChannel().sendMessage("Bot Wins");
			playing = false;
			easy = false;
		}
		if (botHand1.length() + botHand2.length() == 0 && playing == true) {
			event.getChannel().sendMessage("Player Wins");
			playing = false;
			easy = false;
		}
		if (playing == false) {
			hand1 = "I";
			hand2 = "I";
			botHand1 = "I";
			botHand2 = "I";

		}

	}

	// II II
	//
	// III I
	private void HandleBotPlayHard(MessageCreateEvent event) {
		// TODO Auto-generated method stub
		if(botHand1.length()+hand1.length()>=5) {
			
		}
		
		if (botHand1.equals("II") && botHand2.equals("I")) {
			botHand1 = "I";
			botHand2 = "II";
		}else if(botHand1.equals("I") && botHand2.equals("II")) {
			botHand1 = "II";
			botHand2 = "I";
			
		}if(botHand1.equals(botHand2)) {
			if(hand1.length()>=hand2.length()) {
				hand1+=botHand1;
				
			}else if(hand2.length()>=hand1.length()) {
				hand2+=botHand1;
				
			}
		}
		if (hand1.length() >= 5) {
			hand1 = "";
		}
		if (hand2.length() >= 5) {
			hand2 = "";
		}
		if (botHand1.length() >= 5) {
			botHand1 = "";
		}
		if (botHand2.length() >= 5) {
			botHand2 = "";
		}
	}

	private void HandleSplit(String str, MessageCreateEvent event) {
		// TODO Auto-generated method stub
		String[] move = str.split(" ");
		event.getChannel().sendMessage(move[0]);
		int num = Integer.parseInt(move[1]);
		if (move[0].equals("right")) {
			event.getChannel().sendMessage("test2");
			if (hand1.length() > num) {

				String temp = "";
				for (int i = 0; i < num; i++) {
					temp += "I";
				}
				hand2 += temp;
				hand1 = hand1.substring(0, hand1.length() - temp.length());
				/*
				 * int number = hand1.length() - temp.length(); for (int i = 0; i < number; i++)
				 * { remove += "I"; } hand1 = remove;
				 */
			}
		} else {
			event.getChannel().sendMessage("invalid message");

		}
		event.getChannel().sendMessage("Bot:   " + botHand1 + "     " + botHand2);
		event.getChannel().sendMessage("You:   " + hand1 + "     " + hand2);

	}

	private void HandleBotPlayEasy(MessageCreateEvent event) {
		// TODO Auto-generated method stub
		if (hand1.length() >= hand2.length()) {
			if (botHand1.length() >= botHand2.length()) {
				hand1 += botHand1;
			} else {
				hand1 += botHand2;
			}
		} else {
			if (botHand1.length() >= botHand2.length()) {
				hand2 += botHand1;
			} else {
				hand2 += botHand2;
			}
		}
		if (hand1.length() >= 5) {
			hand1 = "";
		}
		if (hand2.length() >= 5) {
			hand2 = "";
		}
		if (botHand1.length() >= 5) {
			botHand1 = "";
		}
		if (botHand2.length() >= 5) {
			botHand2 = "";
		}
		event.getChannel().sendMessage("Bot:   " + botHand1 + "     " + botHand2);
		event.getChannel().sendMessage("You:   " + hand1 + "     " + hand2);

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
		if (hand1.length() >= 5) {
			hand1 = "";
		}
		if (hand2.length() >= 5) {
			hand2 = "";
		}
		if (botHand1.length() >= 5) {
			botHand1 = "";
		}
		if (botHand2.length() >= 5) {
			botHand2 = "";
		}
		event.getChannel().sendMessage("Bot:   " + botHand1 + "     " + botHand2);
		event.getChannel().sendMessage("You:   " + hand1 + "     " + hand2);
	}

	private void HandlePlay(String level, MessageCreateEvent event) {
		// TODO Auto-generated method stub
		if (level.equals("easy")) {
			easy = true;
		}
		event.getChannel().sendMessage("Bot:   " + botHand1 + "     " + botHand2);
		event.getChannel().sendMessage("You:   " + hand1 + "     " + hand2);

	}

}
