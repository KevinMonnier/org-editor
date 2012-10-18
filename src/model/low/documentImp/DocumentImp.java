package model.low.documentImp;

import java.util.List;

import model.low.document.Document;
import model.low.document.Section;
import model.low.document.TextIntro;

public class DocumentImp implements Document {
	private TextIntro text;
	private List<Section> sections;
	
	

	@Override
	public Section getSubSection(int i) {
		if(i >= this.sections.size() || i < 0) {
			throw new DocumentException("No such subsection. This document has " + this.sections.size() + "sections");
		}
		return this.sections.get(i);
	}

	@Override
	public int getSubSectionNb() {
		return this.sections.size();
	}

	@Override
	public TextIntro getTextIntro() {
		return this.text;
	}

	@Override
	public void addSubSection(Section subSection) {
		this.sections.add(subSection);
	}

	@Override
	public void deleteSubSection(int i) {
		this.sections.remove(i);
	}

	@Override
	public void addNewSubSection() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addNewSubSection(int at) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addSubSection(Section subSection, int at) {
		this.sections.add(at, subSection);
	}
}
