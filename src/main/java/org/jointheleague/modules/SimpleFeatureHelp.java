package org.jointheleague.modules;

import org.javacord.api.entity.message.embed.EmbedBuilder;

public class SimpleFeatureHelp extends FeatureHelp {
	SimpleFeatureHelp(String featureName) {
		super(featureName);
		this.sections.add(new HelpSection("main"));
	}

	
	void addCommand(String commandName, String commandDescription) {
		this.sections.get(0).addCommand(commandName, commandDescription);
	}


	EmbedBuilder generateEmbed() {
		EmbedBuilder toReturn = new EmbedBuilder();
		toReturn.setTitle("Help Page for: "+featureName);
		for(int j = 0; j < this.sections.get(0).commands.size(); j++) {
			
		}
		return null;
	}
}
