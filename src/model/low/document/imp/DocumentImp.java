package model.low.document.imp;

import model.low.cursor.Cursor;
import model.low.document.Document;
import model.low.document.TextIntro;

public class DocumentImp extends HasSubSectionImp implements Document{
	
	private TextIntro textIntro;
	private Cursor cursor;
	
//	Singleton pattern, has to be replaced by the right structure with the dependency injection framework
	private DocumentImp() {
		this.textIntro = new TextIntroImp();
	}
	
	public Document getDocument(){
		if(this != null) {
			return this;
		}
		return new DocumentImp();
	}
	
	@Override
	public TextIntro getTextIntro() {
		return this.textIntro;
	}

	@Override
	public Cursor getCursor() {
		return cursor;
	}

	@Override
	public void setCursor(Cursor cursor) {
		this.cursor = cursor;
	}

	@Override
	public int getLineNb() {
		int lineNb = this.textIntro.getLineNb();
		for (int i = 0; i < this.getSubSectionNb(); i++) {
			lineNb += this.getSubSection(i).getLineNb();
		}
		return lineNb;
	}

	
}
