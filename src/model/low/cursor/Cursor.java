package model.low.cursor;

import model.low.document.Line;


// The cursor represents the visitor in the Visitor pattern
public interface Cursor extends Visitor{

	/**
	 * Method to init the current Line of the cursor just after been accepted by the document.
	 */
	public void initCursor();
	
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

	void setCurrentPosition(int newPosition);

	int getCurrentPosition();

	Line getCurrentLine();

	void setCurrentLine(Line newLine);
	
}
