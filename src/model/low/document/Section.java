package model.low.document;

public interface Section extends Element, HasSubSection, HasTextIntro, Visitable {

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
	 * Set the state of the Section to Visible or Hidden
	 */
	public void setState(final State NEW_STATE);
	
	/**
	 * Method to know if the Section is visible or not.
	 * @return true if the Section is Visible
	 */
	public boolean isVisible();
}
