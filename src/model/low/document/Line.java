package model.low.document;

public interface Line extends Element{
	
	/**
	 * @return the content of the Line
	 */
	public CharSequence getContent();
	
	/**
	 * Set the content of the Line
	 * @param content 
	 * 				the content to add
	 */
	public void setContent(CharSequence content);

	/**
	 * Inserts the content of the Line passed as an argument to the current Line at the position col
	 * @param col the position where the content will be inserted
	 * @param line the Line that contains the content to add to the current Line
	 */
	public void insert(int col, Line line);

	
	public void replace(int col, int i, Line line);

	public int length();
	
}
