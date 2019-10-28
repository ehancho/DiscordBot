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
	private String steamStats;
	private String C1 = "!PopularSteamGames";
	public GamerBot(String channelName) {
		super(channelName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handle(MessageCreateEvent event) throws APIException {
		// TODO Auto-generated method stub
		steamStats = getSteamStats();
		if (event.getMessageContent().contains(C1)) {
			event.getChannel().sendMessage(steamStats);
		}
	}
	public String getSteamStats() {
	//	boolean reachedStats = false;
		ArrayList<String> TopGames = new ArrayList<String>();
		URL steamURL;
		String stats = "";
		try {
			steamURL = new URL("https://store.steampowered.com/stats/");
			URLConnection con = steamURL.openConnection();
			InputStream is = con.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String line = null;
			line = br.readLine();
			while (line != null) {
				if (line.contains("store.steampowered.com/app") && !line.contains("popup_menu_item")) {
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
	stats = TopGames.get(0);
	return stats;
	}
}
