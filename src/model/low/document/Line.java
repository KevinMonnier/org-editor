package model.low.document;

public interface Line extends Element{
	
	/**
	 * @return the content of the Line
	 */
	public StringBuilder getContent();
	
	/**
	 * Set the content of the Line
	 * @param content 
	 * 				the content to add
	 */
	public void setContent(StringBuilder content);

	
//	Methods to navigate between different Lines
	
	/**
	 * @return the parent of the Line
	 */
	public Text getParent();
	
	/**
	 * @param parent the new parent of the Line
	 */
	public void setParent(Text parent);
	/**
	 * Method to know if the Line is in a Title
	 * @return true if it is in a Title
	 */
	public boolean isInTitle();
	
	/**
	 * Method to know if the Line is in a TextIntro
	 * @return true if it is in a TextIntro
	 */
	public boolean isInTextIntro();
	
	/**
	 * Method to know if the Line is in a Section
	 * @return true if it is in a Section
	 */
	public boolean isInSection();
	
	/**
	 * Method to know if the Line is directly in a Document
	 * @return true if it is directly in a Document
	 */
	public boolean isInDocument();
	
	/**
	 * Method to get the next Line in the tree structure
	 * @return the next Line
	 */
	public Line getNext();
	
	
	/**
	 * Method to get the precedent Line in the tree structure
	 * @return the precedent Line
	 */
	public Line getPrec();

	/**
	 * Method to get the next Line from a Title
	 * @return the next Line
	 */
	public Line getNextFromTitle();
	
	/**
	 * Method to get the precedent Line from a Title
	 * @return the precedent Line
	 */
	public Line getPrecFromTitle();
	
	/**
	 * Method to get the next Line from a TextIntro
	 * @return the next Line
	 */
	public Line getNextFromTextIntro();
	
	/**
	 * Method to get the next Line from a TextIntro
	 * @return the precedent Line
	 */
	public Line getPrecFromTextIntro();
	
	/**
	 * Method to get the index of the Line in List of TextIntroImp.
	 * Returns 0 if the line is in a Title.
	 * @return the index of the Line
	 */
	public int getIndex();

	
//	Methods to manipulate the content of the Line
	
	/**
	 * Inserts the content of the Line passed as a parameter to the current Line at the position pos
	 * @param pos the position where the content will be inserted
	 * @param line the Line that contains the content to add to the current Line
	 */
	public void insertContent(int pos, Line line);

	/**
	 * Inserts the content passed as a parameter to the current Line at the position pos
	 * @param pos the position where the content will be inserted
	 * @param newContent the content to add to the current Line
	 */
	public void insertContent(int pos, StringBuilder newContent);
	
	/**
	 * Method to insert a character in the Line at the position pos.
	 * @param pos the position where the character will be inserted
	 * @param c the character to insert
	 */
	public void insertCharAt(int pos, char c);
	
	/**
	 * Replace the content of the Line by the content of the line passed as a parameter.
	 * @param line the Line that contains the future content of the actual Line
	 */
	public void replaceContent(Line line);

	/**
	 * Replace the content of the Line by the content passed as a parameter.
	 * @param newContent the new content
	 */
	public void replaceContent(StringBuilder newContent);
	
	/**
	 * Sets the content of the Line to an empty StringBuilder.
	 */
	public void deleteContent();
	
	/**
	 * Deletes the character at the position pos-1 in the line.
	 * @param pos corresponds to the position of the cursor in the line
	 */
	public void deletePrecedentCharAt(int pos);
	
	/**
	 * Deletes the character at the position pos in the line.
	 * @param pos corresponds to the position of the cursor in the line
	 */
	public void deleteCharAt(int pos);
	/**
	 * Method to access the length of the Line.
	 * @return the length of the Line
	 */
	public int length();
	
}
