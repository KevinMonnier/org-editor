package model.low.document;

public interface TextIntro extends Component, Text {
	
	/**
	 * @return the number of line in the text
	 */
	public int getLineNb();

	
	/**
	 * @param i the number of the line
	 * @return return the ith line
	 */
	public CharSequence getLine(int i);

	/**
	 * include a line at the given place
	 * @param after number of the line after which the new line is included
	 * @param cs the line to insert
	 */
	public void addLine(int after, CharSequence cs);
	
	/**
	 * Insert a sequence in a line.
	 * @param line the line in which the sequence is included
	 * @param col The column after which the sequence is included
	 * @param str The sequence to include.
	 */
	public void insert(int line, int col, CharSequence str);
	
	
	/**
	 * Remove a sequence from a line.
	 * @param line The number of the line.
	 * @param col The character after which the sequence will be removed
	 * @param length the length of the sequence to remove
	 */
	public void remove(int line, int col, int length);

	/**
	 * Delete a line.
	 * @param i The number of the line to remove.
	 */
	public void deleteLine(int i);
	
}
