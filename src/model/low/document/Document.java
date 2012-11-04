package model.low.document;


public interface Document extends HasSubSection, HasTextIntro, Visitable{

	/**
	 * clear the document.
	 */
	void clear();
	
}
