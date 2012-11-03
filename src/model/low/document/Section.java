package model.low.document;

public interface Section extends Element, HasSubSection, HasTextIntro {

	/**
	 * @return The title of the section.
	 */
	public Title getTitle();
	
	/**
	 * @return The object containing this section.
	 */
	public HasSubSection getParent();
	
	/**
	 * Set the containing Section.
	 */
	public void setParent(HasSubSection parent);

	/**
	 * Method to get the next Section in the tree
	 * @return the next section
	 */
	public Section getNextSection();
	
	public Section getNextSiblingOrAncestor();
	
	/**
	 * Method to get the precedent Section in the tree
	 * @return the precedent Section
	 */
	public Section getPrecSection();
	
	/**
	 * Method to get the index of the Section in List of TasSubSection.
	 * @return the index of the Section
	 */
	public int getIndex();
	
	/**
	 * Method to get the First Line of this Section.
	 * This Line is the Title of this section.
	 * @return the first Line
	 */
	public Line getFirstLine();
	
	/**
	 * Method to get the Last Line of this Section.
	 * This Line can be in a SubSection of this Section.
	 * This Line is the Title of the Section when it is hidden. 
	 * @return
	 */
	public Line getLastLine();
	
	/**
	 * Set the state of the Section to Visible or Hidden
	 */
	public void setState(final State NEW_STATE);
	
	/**
	 * Method to know if the Section is visible or not.
	 * @return true if the Section is Visible
	 */
	public boolean isVisible();
	
	
	/**
	 * Method to get the State of the section
	 * @return the state of the section
	 */
	public State getState();
}
