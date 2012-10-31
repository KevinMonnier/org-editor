package model.low.documentImp;

import model.low.document.Cursor;
import model.low.document.Document;
import model.low.document.TextIntro;

public class DocumentImp extends HasSubSectionImp implements Document{
	
	private TextIntro text;
	private Cursor cursor;
	
	@Override
	public TextIntro getTextIntro() {
		return this.text;
	}

	@Override
	public Cursor getCursor() {
		return cursor;
	}

	
}
