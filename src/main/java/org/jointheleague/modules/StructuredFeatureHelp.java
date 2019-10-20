package org.jointheleague.modules;

public class StructuredFeatureHelp extends FeatureHelp{

	StructuredFeatureHelp(String featureName) {
		super(featureName);
	}
	
	boolean addSection(String newName) {
		if(getSection(newName) == null) {
			this.sections.add(new HelpSection(newName));
			return true;
		}
		else {
			return false;
		}
		
	}
	
	HelpSection getSection(String query) {
		for(int j = 0; j < this.sections.size(); j++) {
			if(sections.get(j).sectionName.equals(query)) {
				return sections.get(j);
			}
		}
		return null;
	}
	

}
