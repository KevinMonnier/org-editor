package model.low.document;

public interface HasSubSection {
	public Section getSubSection(int i);

	public int getSubSectionNb();
	public void addSubSection(Section subSection);
	public void deleteSubSection(int i);
}
