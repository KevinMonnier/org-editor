package model.low.documentImp;

import java.util.List;

import model.low.document.HasSubSection;
import model.low.document.Section;
import model.low.document.TextIntro;
import model.low.document.Title;

public class SectionImp extends HasSubSectionImp implements Section {
	
	private Title title;
	private TextIntro text;
	private HasSubSection parent;

	@Override
	public Title getTitle() {
		return title;
	}

	@Override
	public TextIntro getTextIntro() {
		return this.text;
	}

	@Override
	public HasSubSection getParent() {
		return this.parent;
	}

	@Override
	public void setParent(HasSubSection parent) {
		this.parent = parent;
	}

}
