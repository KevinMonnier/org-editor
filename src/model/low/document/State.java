package model.low.document;

public interface State {

	/**
	 * Method to know if SECTION_CONTEXT is visible or not.
	 * @param SECTION_CONTEXT the section
	 * @return true if SECTION_CONTEXT is in the State "Visible"
	 */
	public boolean isVisible(final Section SECTION_CONTEXT);
	
	/**
	 * Method to change the State of the SECTION_CONTEXT(Visible or Hidden)
	 * @param SECTION_CONTEXT the section
	 */
	public void showHide(final Section SECTION_CONTEXT);
	
}
