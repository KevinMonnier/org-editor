package model.low.document;

public interface HasSubSection {
	
	
	/**
	 * @param i
	 * @return the subSection number i among the subSections 
	 */
	public Section getSubSection(int i);

	/**
	 * @return the number of subSections.
	 */
	public int getSubSectionNb();

	/**
	 * Add a subsection after the other subsections.
	 * 
	 * @param subSection
	 *            the subsection to add.
	 */
	public void addSubSection(Section subSection);

	/**
	 * Add a subsection at the given position (starting at 0)
	 * 
	 * @param subSection
	 *            the subsection to add.
	 * @param at
	 *            the position of the section
	 */
	public void addSubSection(Section subSection, int at);


	/**
	 * Add a subsection after the given section (starting at 0)
	 * @param subSection
	 * @param after
	 */
	public void addSubSection(Section subSection, Section after);
	
	/**
	 * Delete the subsection
	 * 
	 * @param i
	 *            the number of the section to delete, starting at 0
	 */
	public void removeSubSection(int i);
	
	public int getLineNb();
}
