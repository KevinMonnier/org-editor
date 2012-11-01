package model.low.document;

public interface TextIntro extends Text {
	
	/**
	 * @return the number of line in the text
	 */
	public int getLineNb();

	
	/**
	 * @param i the number of the line, starting at 0
	 * @return return the ith line
	 */
	public Line getLine(int i);

	/**
	 * include a line at the given place
	 * @param after number of the line after which the new line is included
	 * @param line the line to insert
	 */
	public void addLine(int after, Line line);
	
	/**
	 * Insert the content of a  Line in a other Line of the text.
	 * @param lineNb the line in which the sequence is included
	 * @param col The column after which the sequence is included
	 * @param line The sequence to include.
	 */
	public void insert(int lineNb, int col, Line line);
	
	
	/**
	 * Remove a sequence from a line.
	 * @param lineNb The number of the line.
	 * @param col The character after which the sequence will be removed
	 * @param length the length of the sequence to remove
	 */
	public void remove(int lineNb, int col, int length);

	/**
	 * Delete a line.
	 * @param i The number of the line to remove.
	 */
	public void deleteLine(int i);
	
}
