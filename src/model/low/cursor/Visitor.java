package model.low.cursor;

import model.low.document.Document;

public interface Visitor {
	
	public Document getDocument();
	
	public void visitDocument(Document document);
	
}
