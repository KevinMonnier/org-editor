package model.low.document.imp;

import java.util.List;

import model.low.document.HasSubSection;
import model.low.document.Section;

public abstract class HasSubSectionImp implements HasSubSection {

	private List<Section> sections;

	@Override
	public Section getSubSection(int i) {
		if (i >= getSubSectionNb() || i < 0) {
			throw new DocumentException(
					"No such subsection. This document has "
							+ this.sections.size() + "sections");
		}
		return this.sections.get(i);
	}

	@Override
	public int getSubSectionNb() {
		return this.sections.size();
	}

	@Override
	public void addSubSection(Section subSection) {
		this.sections.add(subSection);
	}

	@Override
	public void addSubSection(Section subSection, int at) {
		this.sections.add(at, subSection);
	}

	@Override
	public void addSubSection(Section subSection, Section after) {
		this.sections.add(this.sections.indexOf(after), subSection);
	}
	
	@Override
	public void removeSubSection(int i) {
		this.sections.remove(i);
	}

}
