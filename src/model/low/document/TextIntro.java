package model.low.document;

import java.util.List;

public interface TextIntro extends Text {
	
	/**
	 * @return the number of lines in the text
	 */
	public int getLineNb();

	/**
	 * @param i the number of the line, starting at 0
	 * @return return the ith line
	 */
	public Line getLine(int i);

	/**
	 * @return the first line of the TextIntro
	 */
	public Line getFirstLine();
	
	/**
	 * @return the last line of the TextIntro
	 */
	public Line getLastLine();
	
	/**
	 * @return the Line List of the text
	 */
	public List<Line> getText();
	
	/**
	 * @return the parent of the TextIntro in the tree structure
	 */
	public HasTextIntro getParent();
	
	/**
	 * @param parent the parent of the TextIntro in the tree structure
	 */
	public void setParent(HasTextIntro parent);
	
	/**
	 * Add a new Line at the end of the TextIntro.
	 * @param line the line to add
	 */
	public void addLine(Line line);
	
	/**
	 * Inserts a new Line at the given position (starting at 0).
	 * @param line the Line to insert
	 * @param at the position of the Line
	 */
	public void insertLine(Line line, int at);
	
	/**
	 * Inserts a new Line after the given Line (starting at 0).
	 * @param line the Line to insert
	 * @param after the Line the other will be inserted
	 */
	public void insertLine(Line line, Line after);

	/**
	 * Delete a line.
	 * @param i The number of the line to remove.
	 */
	public void remove(int i);
	
}
