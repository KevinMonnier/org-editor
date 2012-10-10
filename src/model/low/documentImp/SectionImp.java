package model.low.documentImp;

import java.util.List;

import model.low.document.Section;
import model.low.document.TextIntro;
import model.low.document.Title;

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
	public Section getSubSection(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TextIntro getTextIntro() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSubSectionNb() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addSubSection(Section subSection) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSubSection(int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLineNum() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
