package org.jointheleague.modules;

import java.util.ArrayList;

import org.javacord.api.entity.message.embed.EmbedBuilder;

public abstract class FeatureHelp {
	String featureName;
	ArrayList<HelpSection> sections;
	
	FeatureHelp(String featureName) {
		this.featureName = featureName;
		sections = new ArrayList<HelpSection>();
	}
	
	abstract EmbedBuilder generateEmbed();
}
