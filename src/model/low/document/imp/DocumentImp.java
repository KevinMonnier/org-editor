package model.low.document.imp;

import model.low.cursor.Visitor;
import model.low.document.Document;
import model.low.document.Section;
import model.low.document.TextIntro;

public class DocumentImp extends HasSubSectionImp implements Document{
	
	private TextIntro textIntro;
	
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
	public void accept(Visitor visitor) {
		visitor.visitDocument(this);
	}
	
	public String toString() {
		String s = getTextIntro().toString();
		for(Section section : getSubSections()) {
			s += section.toString();
		}
		return s;
	}

}
