package model.low.document;

public interface HasSubSection {
	public Section getSubSection(int i);

	/**
	 * @return the number of subSections.
	 */
	public int getSubSectionNb();
	
	/**
	 * Add a new empty subsection after the other subsections.
	 */
	public void addNewSubSection();
	
	/**
	 * Add a new empty subsection at the given position (starting at 0)
	 * @param at the position of the new section
	 */
	public void addNewSubSection(int at);
	
	/**
	 * Add a subsection after the other subsections.
	 * @param subSection the subsection to add.
	 */
	public void addSubSection(Section subSection);
	
	/**
	 * Add a subsection at the given position (starting at 0)
	 * @param subSection the subsection to add.
	 * @param at the position of the section
	 */
	public void addSubSection(Section subSection, int at);
	
	/**
	 * Delete the subsection
	 * @param i the number of the section to delete, starting at 0
	 */
	public void deleteSubSection(int i);
}
