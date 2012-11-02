package model.low.cursor.imp;

import model.low.cursor.Visitor;
import model.low.document.Document;

public abstract class VisitorImp implements Visitor {

	private Document document;
	
	@Override
	public Document getDocument() {
		return document;
	}
	
	@Override
	public void visitDocument(Document document) {
		this.document = document;
	}

}
