package org.jointheleague.modules;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.javacord.api.event.message.MessageCreateEvent;

import net.aksingh.owmjapis.api.APIException;


public class GamerBot extends CustomMessageCreateListener{
	//Commands
	private String HC;
	private String C1, C1D;
	private String C2, C2D;
	private String C3, C3D;
	private String C4, C4D;
	//Other
	private ArrayList<String> GamerGIFs = new ArrayList<String>();
	public GamerBot(String channelName) {
		super(channelName);
		HC = "!help";
		C1 = "!Top10";
		C2 = "!RecentGamingNews";
		C3 = "!GamerGIF";
		C4 = "!";
		// TODO Auto-generated constructor stub
	}
	@Override
	public void handle(MessageCreateEvent event) throws APIException {
		// TODO Auto-generated method stub
		String steamStats = getSteamStats();
		//help command (returns commands and descriptions)
		if (event.getMessageContent().equals(HC)) {
			event.getChannel().sendMessage(getCommandsDescriptions());
		}
		//Top 10 games command
		if (event.getMessageContent().equals(C1)) {
			event.getChannel().sendMessage(steamStats);
		}
		//Gaming news command
		if (event.getMessageContent().equals(C2)) {
			event.getChannel().sendMessage("For the most recent gaming news, visit:" + "\n" + "https://www.pcgamer.com/news/");
		}
		//Random GIF
		if (event.getMessageContent().equals(C3)) {
			event.getChannel().sendMessage(getRandomGIF());
		}
	}
	public String getRandomGIF() {
		GamerGIFs.add("http://giphygifs.s3.amazonaws.com/media/eJAgh7EA5PUic/giphy.gif");
		GamerGIFs.add("https://66.media.tumblr.com/4384e8e9d30a7a5d3c58e0fdf1e7c775/tumblr_n1bn1ewqbt1r3smugo1_500.gifv");
		GamerGIFs.add("https://media.giphy.com/media/l4FGGcoaDPICpJKqk/giphy.gif");
		GamerGIFs.add("http://giphygifs.s3.amazonaws.com/media/ckT59CvStmUsU/giphy.gif");
		GamerGIFs.add("https://media.giphy.com/media/5bu6vx0eOCMYElteG3/giphy.gif");
		GamerGIFs.add("http://giphygifs.s3.amazonaws.com/media/6K1g77Ed57sHK/giphy.gif");
		GamerGIFs.add("https://media.giphy.com/media/PK55P6udUmSPu/giphy.gif");
		GamerGIFs.add("http://giphygifs.s3.amazonaws.com/media/e3i2bqzVlYfMk/giphy.gif");
		GamerGIFs.add("http://giphygifs.s3.amazonaws.com/media/FozFsoJOM4ETK/giphy.gif");
		GamerGIFs.add("https://media.giphy.com/media/EDEpmdcjo8gP6/giphy.gif");
		GamerGIFs.add("https://i.giphy.com/media/M7Bb92XyvQuA/giphy.webp");
		return GamerGIFs.get((int)(Math.random()*GamerGIFs.size()));
	}
	public String getCommandsDescriptions() {
		String helpString = "";
		C1D = " -> This returns 10 games on steam with the most current players";
		C2D = " -> This returns the current news going on in the video game world";
		C3D = " -> This returns a random gaming related GIF";
		helpString += C1 + C1D + "\n" +
					  C2 + C2D + "\n" +
					  C3 + C3D + "\n";
		return helpString;
	}
	public String getSteamStats() { //!GetTop10
		//	boolean reachedStats = false;
		ArrayList<String> TopGames = new ArrayList<String>();
		URL steamURL;
		//String stats = "";
		try {
			steamURL = new URL("https://store.steampowered.com/stats/");
			URLConnection con = steamURL.openConnection();
			InputStream is = con.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String line = null;
			line = br.readLine();
			while (line != null) {
				//System.out.println(line);
				if (line.contains("store.steampowered.com/app") && !line.contains("popup_menu_item")) { //This line is meant to distinguish the top 10 games in the html code (using key words)
					TopGames.add(line);
				}
				line = br.readLine();
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String returnString = "";
		boolean atArrow = false;
		for (int j = 0; j < 10; j++) {
			returnString += Integer.toString(j + 1) + ". ";
			for (int i = 1; i < TopGames.get(j).length(); i++) {
				if (TopGames.get(j).charAt(i - 1) == '>') {
					atArrow = true;
				}
				if (TopGames.get(j).charAt(i) == '<') {
					atArrow = false;
				}
				if (atArrow) {
					returnString += TopGames.get(j).charAt(i);
				}
			}
			returnString += "\n";
		}
		return returnString;
	}
}
