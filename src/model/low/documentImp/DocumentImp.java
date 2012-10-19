package model.low.documentImp;

import java.util.List;

import model.low.document.Document;
import model.low.document.Section;
import model.low.document.TextIntro;

public class DocumentImp extends HasSubSectionImp implements Document{
	private TextIntro text;
	
	@Override
	public TextIntro getTextIntro() {
		return this.text;
	}

	
}
