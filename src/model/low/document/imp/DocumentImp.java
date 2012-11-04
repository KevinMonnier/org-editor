package model.low.document.imp;

import model.low.cursor.Visitor;
import model.low.document.Document;
import model.low.document.Section;
import model.low.document.TextIntro;

public class DocumentImp extends HasSubSectionImp implements Document{
	
	private static final Document INSTANCE = new DocumentImp();
	
	private TextIntro textIntro;
	
//	Singleton pattern, has to be replaced by the right structure with the dependency injection framework
	private DocumentImp() {
		this.textIntro = new TextIntroImp(this);
		this.textIntro.addLine(new LineImp(this.textIntro)); //TODO injection here
	}
	
	public static Document getDocument(){
		return INSTANCE;
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

	@Override
	public int getLineNb() {
		int lineNb = this.textIntro.getLineNb();
		for (int i = 0; i < this.getSubSectionNb(); i++) {
			lineNb += this.getSubSection(i).getLineNb();
		}
		return lineNb;
	}

	@Override
	public void clear() {
		this.textIntro = new TextIntroImp(this);
		this.getSubSections().clear();
	}

	
}
