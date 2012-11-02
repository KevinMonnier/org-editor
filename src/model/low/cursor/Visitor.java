package model.low.cursor;

import java.util.List;

import model.low.document.Document;
import model.low.document.Section;
import model.low.document.TextIntro;
import model.low.document.Title;

public interface Visitor {
	
	public void visitDocument(Document document);
	
	public void visitTextIntro(TextIntro text);
	
	public void visitSubSections(List<Section> sections);
	
	public void visitSubSection(Section section);
	
	public void visitTitle(Title title);
	
}
