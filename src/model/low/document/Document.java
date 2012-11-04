package model.low.document;


public interface Document extends HasSubSection, HasTextIntro, Visitable{

	/**
	 * clear the document.
	 */
	void clear();
	
	/**
	 * Method to know if the Line passed as an parameter is the first Line in the Document.
	 * @param line
	 * @return true if line is the first Line in the Document
	 */
	public boolean isFirstLineOfTheDocument(Line line);
	
	/**
	 * Method to know if the Line passed as an parameter is the last Line in the Document.
	 * @param line
	 * @return true if line is the last Line in the Document
	 */
	public boolean isLastLineOfTheDocument(Line line);
	
}
