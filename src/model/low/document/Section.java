package model.low.document;

public interface Section extends Composite, Component, HasSubSection, HasTextIntro{

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

}
