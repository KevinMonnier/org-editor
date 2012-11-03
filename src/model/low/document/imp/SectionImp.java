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
	
	public SectionImp(Title title, HasSubSection parent) {
		this.title = title;
		this.title.setParent(this);
		this.parent = parent;
		this.text = new TextIntroImp(this);
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
	public Section getNextSection() {
		if(this.getSubSectionNb() > 0){
			return this.getSubSection(0);
		} else 
			if (this.getParent().getSubSectionNb() - 1 > this.getIndex()) {
			return this.getParent().getSubSection(this.getIndex() + 1);
		} else if(this.getParent() instanceof SectionImp) {
			return ((SectionImp)this.getParent()).getNextSiblingOrAncestor();
		} else {
			return null;
		}	
	}

	@Override
	public Section getNextSiblingOrAncestor() {
		HasSubSection parent = this.getParent();
		if(this.getIndex() == parent.getSubSectionNb() - 1) {
			if(parent instanceof Section)
				return ((Section)parent).getNextSiblingOrAncestor();
		}
		else {
			return parent.getSubSection(this.getIndex() +1 );
		}
		return null;
	}

	@Override
	public Section getPrecSection() {
		if(this.getIndex() > 0) {
			if (this.getParent().getSubSection(this.getIndex() - 1).getSubSectionNb() > 0) {
				return this.getParent().getLastDescendant();
			} else {
				return this.getParent().getSubSection(this.getIndex() - 1);
			}
		} else if(this.getParent() instanceof SectionImp)	{
			return (SectionImp)this.getParent();
		} else {
			return null;
		}	
	}

	@Override
	public int getIndex() {
		return this.getParent().getSubSections().indexOf(this);
	}
	
	@Override
	public Line getFirstLine() {
		return this.getTitle().getLine();
	}

	@Override
	public Line getLastLine() {
		if(this.isVisible()) {
			if(this.getSubSectionNb() > 0) {
				return this.getSubSection(this.getSubSectionNb() - 1 ).getLastLine();
			}
			if(this.getTextIntro().getLineNb() > 0)
				return this.getTextIntro().getLine(this.getTextIntro().getLineNb() - 1 );
			else 
				return this.getTitle().getLine();
		}
		return this.getTitle().getLine();
	}
	
	@Override
	public void setState(final State NEW_STATE) {
		this.state = NEW_STATE;
		
	}

	@Override
	public boolean isVisible() {
		return state.isVisible();
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

	@Override
	public State getState() {
		return this.state;
	}

}
