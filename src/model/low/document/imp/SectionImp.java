package model.low.document.imp;

import model.low.document.HasSubSection;
import model.low.document.Line;
import model.low.document.Section;
import model.low.document.State;
import model.low.document.TextIntro;
import model.low.document.Title;

public class SectionImp extends HasSubSectionImp implements Section {
	
	private Title title;
	private TextIntro text;
	private HasSubSection parent;
	private State state;
	
	public SectionImp(Title title, HasSubSection parent, TextIntro text) {
		this.title = title;
		this.parent = parent;
		this.text = text;
		this.setState(new Visible());
	}
	
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

	@Override
	public Section getNext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Section getPrec() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Line getFirstLine() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Line getLastLine() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void setState(final State NEW_STATE) {
		this.state = NEW_STATE;
		
	}

	@Override
	public boolean isVisible() {
		return state.isVisible(this);
	}

	@Override
	public int getLineNb() {
		int lineNb = this.text.getLineNb() + 1; // +1 for the title
		for (int i = 0; i < this.getSubSectionNb(); i++) {
			lineNb += this.getSubSection(i).getLineNb();
		}
		return lineNb;
	}

	public String toString() {
		String s = getTitle().toString();	
		if(isVisible()) {
			s += getTextIntro().toString();
			for(Section section : getSubSections()) {
				s += section.toString();
			}
		}
		return s;
	}

}
