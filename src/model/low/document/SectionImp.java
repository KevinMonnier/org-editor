package model.low.document;

import java.util.List;

public class SectionImp implements Section {
	private Title title;
	private TextIntro text;
	private List<Section> sections;
	private boolean visible;
	
	
	@Override
	public Title getTitle() {
		return title;
	}
	@Override
	public TextIntro getTextIntro() {
		return text;
	}
	@Override
	public boolean isVisible() {
		return visible;
	}
}
