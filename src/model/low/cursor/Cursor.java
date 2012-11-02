package model.low.cursor;


// The cursor represents the visitor in the Visitor pattern
public interface Cursor extends Visitor{

	/**
	 * @return the Instance of the actual Cursor
	 */
	public Cursor getCursor();
	
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
