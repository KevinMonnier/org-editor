package model.low.documentImp;

import model.low.document.Document;
import model.low.document.TextIntro;

public class DocumentImp extends HasSubSectionImp implements Document{
	private TextIntro text;
	
	@Override
	public TextIntro getTextIntro() {
		return this.text;
	}

	
}
