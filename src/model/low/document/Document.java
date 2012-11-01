package model.low.document;

import model.low.cursor.Cursor;

public interface Document extends HasSubSection, HasTextIntro{

	/**
	 * 
	 * @return
	 */
	public Document getDocument();
	
	/**
	 * 
	 * @return
	 */
	public Cursor getCursor();
	
	/**
	 * Corresponds to the accept(Visitor) method in the pattern Visitor
	 * @param cursor
	 */
	public void setCursor(Cursor cursor);
	
}
