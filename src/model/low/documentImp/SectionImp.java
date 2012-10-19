package model.low.documentImp;

import java.util.List;

import model.low.document.HasSubSection;
import model.low.document.Section;
import model.low.document.TextIntro;
import model.low.document.Title;

public class SectionImp extends HasSubSectionImp implements Section {
	
	private Title title;
	private TextIntro text;

	@Override
	public Title getTitle() {
		return title;
	}

	@Override
	public int getLineNum() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TextIntro getTextIntro() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HasSubSection getParent() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
