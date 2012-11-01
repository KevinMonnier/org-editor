package model.low.cursor;

import model.low.document.imp.DocumentImp;

// The cursor represents the visitor in the Visitor pattern
public interface Cursor {

	/**
	 * @return the Instance of the actual Cursor
	 */
	public Cursor getCursor();
	
	/**
	 * @return the instance of DocumentImp which is visited
	 */
	public DocumentImp getDocumentImp();
	
	/**
	 * Corresponds to the visit(ConcreteElement) method in the pattern Visitor
	 * @param documentImp the document which is visited
	 */
	public void setDocumentImp(DocumentImp documentImp);
	
	/**
	 * Moves the position of the cursor to the left.
	 */
	public void movePositionLeft();
	
	/**
	 * Moves the position of the cursor to the right.
	 */
	public void movePositionRight();
	
	/**
	 * Selects the Line just above the current selected line.
	 */
	public void selectLineUp();
	
	/**
	 * Selects the Line just below the current selected line.
	 */
	public void selectLineDown();
	
}
