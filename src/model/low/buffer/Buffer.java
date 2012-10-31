package model.low.buffer;

import model.low.document.Element;

public interface Buffer {
	
	public Element push(Element e);
	
	public Element pop();
	
	public Element peek();
	
}
