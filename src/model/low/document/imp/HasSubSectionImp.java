package model.low.document.imp;

import java.util.LinkedList;
import java.util.List;
import model.low.document.HasSubSection;
import model.low.document.Section;

public abstract class HasSubSectionImp implements HasSubSection {

	private List<Section> subSections = new LinkedList<Section>();

	@Override
	public List<Section> getSubSections() {
		return subSections;
	}
	
	@Override
	public Section getSubSection(int i) {
		if (i >= getSubSectionNb() || i < 0) {
			throw new DocumentException(
					"No such subsection. This item has "
							+ this.subSections.size() + " sections, cannot get section " + i);
		}
		return this.subSections.get(i);
	}

	@Override
	public int getSubSectionNb() {
		return this.subSections.size();
	}

	@Override
	public void addSubSection(Section subSection) {
		subSection.setParent(this);
		this.subSections.add(subSection);
	}

	@Override
	public void insertSubSection(Section subSection, int at) {
		subSection.setParent(this);
		this.subSections.add(at, subSection);
	}

	@Override
	public void insertSubSection(Section subSection, Section after) {
		subSection.setParent(this);
		this.subSections.add(this.subSections.indexOf(after) + 1, subSection);
	}
	
	@Override
	public void removeSubSection(int i) {
		this.subSections.remove(i);
	}

	@Override
	public Section getLastDescendant(){
		Section lastSubSection = this.getSubSection(this.getSubSectionNb() - 1);
		if (lastSubSection.getSubSectionNb() > 0) {
			return lastSubSection;
		}
		return lastSubSection.getLastDescendant();
	}
}
