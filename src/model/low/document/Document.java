package model.low.document;


public interface Document extends HasSubSection, HasTextIntro, Visitable{

	/**
	 * Accessor nessessary in the Singleton pattern
	 * @return the Document
	 */
	public Document getDocument();
	
}
