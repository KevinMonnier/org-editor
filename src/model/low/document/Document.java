package model.low.document;

import model.low.cursor.Cursor;

public interface Document extends HasSubSection, HasTextIntro{

	public Cursor getCursor();
	
}
