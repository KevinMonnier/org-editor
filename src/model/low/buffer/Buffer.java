package model.low.buffer;

import model.low.document.Element;

public interface Buffer {
	
	/**
	 * Pushes an Element onto the top of this stack.
	 * @param e the Element
	 * @return the Element
	 */
	public Element push(Element e);
	
	/**
	 * Removes the Element at the top of this stack and returns that Element as the value of this function.
	 * @return the Element
	 */
	public Element pop();
	
	/**
	 * Looks at the Element at the top of this stack without removing it from the stack.
	 * @return the Element
	 */
	public Element peek();
	
	/**
	 *  Tests if this stack is empty.
	 * @return true if it is empty
	 */
	public boolean empty();
}
